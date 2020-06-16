package ProjectPractice.IdempotentFrame;

/**
 * author: WentaoKing
 * created on: 2020/6/16
 * description: 幂等号redis存储类
 * 具体实现忽略
 */
public class RedisClusterIdempotenceStorage implements IdempotenceStorage{
    @Override
    public boolean saveIfAbsent(String idempotenceId) {
        return false;
    }

    @Override
    public void delete(String idempotenceId) {

    }
}
