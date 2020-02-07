package perfection;

import practice.iterator.RequestStat;

import java.util.Map;

/**
 * Created by WenTaoKing on 2020/2/7
 * description: 统计数据显示到终端的接口
 */
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats,long startTimeInMillis, long endTimeInMills);
}
