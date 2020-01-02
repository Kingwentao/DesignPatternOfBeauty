package practice.minprotype;

import Basic1.controller.UserVo;

import java.util.concurrent.TimeUnit;

/**
 * author: WentaoKing
 * created on: 2019/12/30
 * description: 把整个框架分为四个模块：数据采集、存储、聚合统计、显示
 *
 * 1。数据采集：负责打点采集原始数据，包括记录每次接口请求的响应时间和请求时间。数据采集过程要高度容错，不能影响到接口本身的可用性。除此之外，
 * 因为这部分功能是暴露给框架的使用者的，所以在设计数据采集 API 的时候，我们也要尽量考虑其易用性。
 *
 * 2。存储：负责将采集的原始数据保存下来，以便后面做聚合统计。数据的存储方式有多种，
 * 比如：Redis、MySQL、HBase、日志、文件、内存等。数据存储比较耗时，为了尽量地减少对接口性能（比如响应时间）的影响，采集和存储的过程异步完成。
 *
 * 3。聚合统计：负责将原始数据聚合为统计数据，
 * 比如：max、min、avg、pencentile、count、tps 等。为了支持更多的聚合统计规则，代码希望尽可能灵活、可扩展。
 *
 * 4。显示：负责将统计数据以某种格式显示到终端，比如：输出到命令行、邮件、网页、自定义显示终端等。
 */
public class UserController {
    private Metrics metrics = new Metrics();

    public UserController(){
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    public void register(UserVo user){
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimeStamp("register",startTimestamp);

        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register",respTime);
    }

    public void login(String telephone,String password){
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimeStamp("login",startTimestamp);

        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login",respTime);
    }
}
