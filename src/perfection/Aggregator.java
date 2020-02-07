package perfection;

import practice.iterator.RequestInfo;
import practice.iterator.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WenTaoKing on 2020/2/7
 * description: 根据原始数据，计算得到统计数据。
 * 我们可以将这部分逻辑移动到 Aggregator 类中。这样 Aggregator 类就不仅仅是只包含统计方法的工具类了
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat =
                    doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis / 1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        return 1.0;
    }

    private double min(List<Double> dataset) {
        return 1.0;
    }

    private double avg(List<Double> dataset) {
        return 1.0;
    }

    private double tps(int count, double duration) {
        return 1.0;
    }

    private double percentile999(List<Double> dataset) {
        return 1.0;
    }

    private double percentile99(List<Double> dataset) {
        return 1.0;
    }

    private double percentile(List<Double> dataset, double ratio) {
        return 1.0;
    }
}
