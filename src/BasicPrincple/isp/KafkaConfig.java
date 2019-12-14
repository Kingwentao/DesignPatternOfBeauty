package BasicPrincple.isp;

import sun.rmi.runtime.Log;

/**
 * author: WentaoKing
 * created on: 2019/12/14
 * description: KafkaConfig 的配置
 */
public class KafkaConfig implements Updater {
    @Override
    public void update() {
        System.out.println("KafkaConfig update");
    }
}
