package BasicPrincple.isp;

import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2019/12/14
 * description:
 */
public class RedisConfig implements Updater,Viewer{

    @Override
    public void update() {
        System.out.println("Redis config update");
    }

    @Override
    public String outputInPlainText() {
        System.out.println("i am redis configuration");
        return "i am redis configuration";
    }

    @Override
    public Map<String, String> output() {
        System.out.println("output");
        return null;
    }
}
