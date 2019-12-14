package BasicPrincple.isp;

/**
 * author: WentaoKing
 * created on: 2019/12/14
 * description:
 */
public class RedisConfig implements Updater{

    @Override
    public void update() {
        System.out.println("Redis config update");
    }
}
