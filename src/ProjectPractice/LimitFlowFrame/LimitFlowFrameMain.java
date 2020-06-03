package ProjectPractice.LimitFlowFrame;

/**
 * author: WentaoKing
 * created on: 2020/5/30
 * description: 项目实战1： 限流框架
 * 限制每个调用方对接口请求的频率。当超过预先设定的访问频率后，我们就触发限流熔断
 * 为了更加精细化地限流，除了限制每个调用方对公共服务平台总的接口请求频率之外，我们还希望能对单独某个接口的访问频率进行限制
 *
 * v1版本（考虑代码的扩展性，预留好扩展点）：
 * 接口类型： 只支持HTTP接口（URL）的限流，不支持RPC等其他类型的接口限流
 * 限流规则： 只支持本地文件配置，配置格式只支持YAML
 * 限流算法： 只支持固定时间窗口算法
 * 限流模式： 只支持单机限流
 *
 */
public class LimitFlowFrameMain {

}
