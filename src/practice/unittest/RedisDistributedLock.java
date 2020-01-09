package practice.unittest;

/**
 * author: WentaoKing
 * created on: 2020/1/9
 * description:  RedisDistributedLock 是一个单例类。
 * 单例相当于一个全局变量，我们无法 mock（无法继承和重写方法），也无法通过依赖注入的方式来替换。
 */
public class RedisDistributedLock {

    private static RedisDistributedLock mRedisDistributedLock = null;

    public static RedisDistributedLock getSingletonInstance() {
        if (mRedisDistributedLock == null){
            mRedisDistributedLock = new RedisDistributedLock();
        }
        return mRedisDistributedLock;
    }

    public void unlockTransaction(String id) {

    }

    public boolean lockTransction(String id) {
        return false;
    }
}
