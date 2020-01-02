package practice.iterator;

import java.util.List;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/1/2
 * description: 负责原始数据存储
 *
 */
public interface MetricsStorage {
    /**
     * 存储请求的信息
     * @param requestInfo
     */
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfoByDuration(String apiName,long startTimestamp,long endTimestamp);

    Map<String,List<RequestInfo>> getAllRequestInfoByDuration(long startTimestamp, long endTimestamp);
}
