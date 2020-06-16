package ProjectPractice.IdempotentFrame;

/**
 * author: WentaoKing
 * created on: 2020/6/15
 * description: 幂等框架
 */
public class Idempotence {

    private IdempotenceStorage storage;

    Idempotence(IdempotenceStorage storage) {
        this.storage = storage;
    }

    boolean saveIfAbsent(String idempotenceId) {
        return storage.saveIfAbsent(idempotenceId);
    }

    public void delete(String idempotenceId) {
        storage.delete(idempotenceId);
    }
}
