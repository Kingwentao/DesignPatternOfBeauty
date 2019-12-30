package BasicPrincple.minprotype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.max;
import static java.util.Collections.min;


/**
 * author: WentaoKing
 * created on: 2019/12/30
 * description: 最小原型实现统计用户注册、登录这两个接口的响应时间的最大值和平均值、接口调用次数
 */
public class Metrics {
    // Map的key是接口名称，value对应接口请求的响应时间或时间戳；
    private Map<String,List<Double>> responseTimes = new HashMap<>();
    private Map<String,List<Double>> timestamps = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void recordResponseTime(String apiName,double responseTime){
        responseTimes.putIfAbsent(apiName,new ArrayList<>());
        timestamps.get(apiName).add(responseTime)
    }

    public void recordTimeStamp(String apiName,double timeStamp){
        timestamps.putIfAbsent(apiName,new ArrayList<>());
        timestamps.get(apiName).add(timeStamp);
    }

    public void startRepeatedReport(long period, TimeUnit unit){
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Map<String,Map<String,Double>> stats = new HashMap<>();
                for (Map.Entry<String,List<Double>> entry: responseTimes.entrySet()){
                    String apiName = entry.getKey();
                    List<Double> apiRespTimes = entry.getValue();
                    stats.putIfAbsent(apiName,new HashMap<>());
                    stats.get(apiName).put("max",max(apiRespTimes));
                    stats.get(apiName).put("min",min(apiRespTimes));
                }
            }
        },0,period,unit);
    }


}
