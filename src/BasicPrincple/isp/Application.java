package BasicPrincple.isp;

/**
 * author: WentaoKing
 * created on: 2019/12/16
 * description: ISP 实例。
 * 接口隔离： 对于RedisConfig和KafkaConfig，都需要热更新接口，但RedisConfig需要在浏览器展示配置信息，KafkaConfig不需要
 * 所以要单独写一个Viewer这个接口，做到接口隔离
 */
public class Application {
    public static final RedisConfig redisConfig = new RedisConfig();
    public static final KafkaConfig kafkaConfig = new KafkaConfig();

    public static void main(String[] args) {
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig,60,60);
        redisConfigUpdater.run();

        //添加kafka的热更新
        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig,60,60);
        kafkaConfigUpdater.run();

        //
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1",5555);
        simpleHttpServer.addViewers("/config",redisConfig);
        simpleHttpServer.run();
    }
}
