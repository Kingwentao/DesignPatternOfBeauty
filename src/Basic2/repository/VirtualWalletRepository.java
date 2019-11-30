package Basic2.repository;

import java.math.BigDecimal;

/**
 * author: WentaoKing
 * created on: 2019/11/29
 * description: Repository 和 Entity 负责数据存取
 */
public class VirtualWalletRepository {

    public VirtualWalletEntity getWalletEntity(Long walletId) {
        return null;
    }

    /**
     * 更新余额
     * @param walletId
     * @param subtract
     */
    public void updateBalance(Long walletId, BigDecimal subtract) {

    }
}
