package perfection;

import practice.iterator.MetricsStorage;
import practice.iterator.RequestInfo;
import practice.iterator.RequestStat;

import java.util.List;
import java.util.Map;

/**
 * Created by WenTaoKing on 2020/2/11
 * description: 定时report基类
 */
public abstract class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStateAndReporter(long startTimeInMillis, long endTimeInMillis){
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfo = metricsStorage.
                getAllRequestInfoByDuration(startTimeInMillis,endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfo,durationInMillis);
        viewer.output(requestStats,startTimeInMillis,endTimeInMillis);
    }
}
