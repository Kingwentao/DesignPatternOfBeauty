package ProjectPractice.IdempotentFrame;

/**
 * author: WentaoKing
 * created on: 2020/6/16
 * description: 用来读写幂等号
 */
public interface IdempotenceStorage {

    /**
     * 存储幂等号
     *
     * @param idempotenceId
     * @return
     */
    boolean saveIfAbsent(String idempotenceId);

    /**
     * 删除幂等号
     *
     * @param idempotenceId
     */
    void delete(String idempotenceId);

}
