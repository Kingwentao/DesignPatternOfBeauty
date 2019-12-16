package Basic2.DService;

import java.math.BigDecimal;

/**
 * author: WentaoKing
 * created on: 2019/12/2
 * description:  Domain领域模型(充血模型)
 */
public class VirtualWallet {
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;

    private boolean isAllowedOverdraft = true;
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    private BigDecimal frozenAmount = BigDecimal.ZERO;


    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public void freeze(BigDecimal amount) {
        //
    }

    public void unfreeze(BigDecimal amount) {
        //
    }

    public void increaseOverdraftAmount(BigDecimal amount) {
        //
    }

    public void decreaseOverdraftAmount(BigDecimal amount) {
        //
    }

    public void closeOverdraft() {
        //
    }

    public void openOverdraft() {
        //
    }

    public BigDecimal balance() {
        return this.balance;
    }

    public void debit(BigDecimal amount) {
//        if (this.balance.compareTo(amount) < 0) {
//            throw new InsufficientBalanceException();
//        }
//        this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
//        if (amount.compareTo(BigDecimal.ZERO) < 0) {
//            throw new InvalidAmountException("eee");
//        } this.balance.add(amount);
    }

    public BigDecimal getAvailableBalance() {
        BigDecimal totalAvailableBalance = this.balance.subtract(this.frozenAmount);
//        if (isAllowedOverdraft) {
//            totalAvailableBalance += this.overdraftAmount;
//        }
        return totalAvailableBalance;
    }


}
