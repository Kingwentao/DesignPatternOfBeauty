package DesignPattern.BehavioralPattern.StrategyPattern.sortExample;

import java.util.HashMap;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/3/23
 * description: sort排序算法的工厂类
 */
public class SortAlgFactory {

    private static final Map<String, ISortAlg> mSortMap = new HashMap<>();

    static {
        mSortMap.put("QuickSort", new QuickSort());
        mSortMap.put("ExternalSort", new ExternalSort());
        mSortMap.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        mSortMap.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return mSortMap.get(type);
    }

}
