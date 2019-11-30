package Basic2.controller;

import java.math.BigDecimal;

/**
 * author: WentaoKing
 * created on: 2019/11/29
 * description: 贫血的传统开发模式
 * Controller暴露接口
 */
public class VirtualWalletController {
    private VirtualWalletController mVirtualWalletService;

    //查询余额
    public BigDecimal getBalance(Long walletId) {
        return null;
    }

    //出账
    public void debit(Long walletId, BigDecimal bigDecimal) {
    }

    //入账
    public void credit(Long walletId, BigDecimal bigDecimal) {
    }

    //交易
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
    }
}
