package DesignPattern.BehavioralPattern.StrategyPattern.sortExample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/23
 * description: 相较于第一张排序方式，把选择排序方法的if-else逻辑通过集合缓存起来，需要的
 * 排序的时候去遍历寻找符合条件的那一项
 */
public class Sorter2 {
    public static final long GB = 1000 * 1000 * 1000;

    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
    }

    public void sortFiles(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg = null;
        for (AlgRange algRange: algs){
            if (algRange.inRange(fileSize)){
                sortAlg = algRange.alg;
                break;
            }
        }
        sortAlg.sort(filePath);
    }

    private static class AlgRange {
        private long start;
        private long end;
        private ISortAlg alg;

        public AlgRange(long start, long end, ISortAlg alg) {
            this.start = start;
            this.end = end;
            this.alg = alg;
        }

        public ISortAlg getAlg() {
            return alg;
        }

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }
}
