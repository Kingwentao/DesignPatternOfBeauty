package ProjectPractice.IdempotentFrame;

import java.util.UUID;

/**
 * author: WentaoKing
 * created on: 2020/6/16
 * description: 幂等号生成类
 */
public class IdempotenceIdGenerator {

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
