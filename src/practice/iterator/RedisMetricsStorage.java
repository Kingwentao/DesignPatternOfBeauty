package practice.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/1/2
 * description: Redis存储数据
 * MetricsStorage 和 RedisMetricsStorage 的设计比较简单。当我们需要实现新的存储方式的时候，只需要实现 MetricsStorage 接口即可。
 * 因为所有用到 MetricsStorage 和 RedisMetricsStorage 的地方，都是基于相同的接口函数来编程的
 * 所以，除了在组装类的地方有所改动（从 RedisMetricsStorage 改为新的存储实现类），其他接口函数调用的地方都不需要改动，满足开闭原则。
 *
 */

public class RedisMetricsStorage implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfoByDuration(String apiName, long startTimestamp, long endTimestamp) {
        List<RequestInfo> requestInfos = new ArrayList<>();
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getAllRequestInfoByDuration(long startTimestamp, long endTimestamp) {
        return null;
    }
}


/*
 * 问题：
 * 一次性取太长时间区间的数据，可能会导致拉取太多的数据到内存中，
 * 有可能会撑爆内存。对于 Java 来说，就有可能会触发 OOM（Out Of Memory）。
 * 而且，即便不出现 OOM，内存还够用，但也会因为内存吃紧，导致频繁的 Full GC，进而导致系统接口请求处理变慢，甚至超时
 */