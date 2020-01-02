package practice.iterator;

/**
 * author: WentaoKing
 * created on: 2020/1/2
 * description: 负责提供API，采集接口请求的原始数据
 * 职责相对来说还算比较单一。它基于接口而非实现编程，
 * 通过依赖注入的方式来传递 MetricsStorage 对象，可以在不需要修改代码的情况下，灵活地替换不同的存储方式，满足开闭原则。
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage){
        this.metricsStorage = metricsStorage;
    }

    //用一个函数代替最小原型的两个函数
    public void recordRequest(RequestInfo requestInfo){
        if(requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }
        //
        metricsStorage.saveRequestInfo(requestInfo);
    }


}
