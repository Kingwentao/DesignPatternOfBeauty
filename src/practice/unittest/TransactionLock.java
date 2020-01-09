package practice.unittest;

/**
 * author: WentaoKing
 * created on: 2020/1/9
 * description: 使用添加的中间层获取RedisDistributedLock对象，便于单元测试
 */
public class TransactionLock {

    public boolean lock(String id){
        return RedisDistributedLock.getSingletonInstance().lockTransction(id);
    }

    public void unlock(String id){
        RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
    }


}
