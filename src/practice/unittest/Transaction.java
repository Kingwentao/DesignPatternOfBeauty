package practice.unittest;

import com.sun.istack.internal.Nullable;

import javax.transaction.InvalidTransactionException;

/**
 * author: WentaoKing
 * created on: 2020/1/9
 * description:  抽象简化的交易类
 */
public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private Long orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;
    // 添加一个成员变量及其set方法
    private WalletRpcService walletRpcService;
    //添加一个TransactionLock对象和set方法，便于测试
    private TransactionLock lock;

    /**
     * 交易 id 的赋值逻辑稍微复杂。我们最好也要测试一下，以保证这部分逻辑的正确性。
     * 为了方便测试，我们可以把 id 赋值这部分逻辑单独抽象到一个函数中
     *
     * @param preAssignedId
     * @param buyerId
     * @param sellerId
     * @param productId
     * @param orderId
     */
    public Transaction(@Nullable String preAssignedId, Long buyerId, Long sellerId, Long productId, Long orderId) {

        // 交易 id 的赋值逻辑稍微复杂。我们最好也要测试一下，以保证这部分逻辑的正确性。为了方便测试，我们可以把 id 赋值这部分逻辑单独抽象到一个函数中
//        if (preAssignedId != null && !preAssignedId.isEmpty()) {
//            this.id = preAssignedId;
//        } else {
//            this.id = IdGenerator.generateTransactionId();
//        }
//        if (!this.id.startWith("t_")) {
//            this.id = "t_" + preAssignedId;
//        }
        fillTransactionId(preAssignedId);

        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimestamp();
    }


    /**
     * 我们可以把 id 赋值这部分逻辑单独抽象到一个函数中,方便单元测试
     * @param preAssignedId
     */
    protected void fillTransactionId(String preAssignedId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
    }

    /**
     * 通过依赖注入的方式 创造walletRpcService对象
     *
     * @param walletRpcService
     */
    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    /**
     * 通过依赖注入的方式 创造TransactionLock对象
     *
     * @param lock
     */
    public void setTransactionLock(TransactionLock lock) {
        this.lock = lock;
    }

    /**
     * 对于有效期的测试，代码中包含跟“时间”有关的“未决行为”逻辑，我们一般的处理方式是将这种未决行为逻辑重新封装
     *
     * @return
     */
    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimestamp();
        return executionInvokedTimestamp - createdTimestamp > 14d ays;
    }

    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null || (sellerId == null || amount < 0.0))) {
            throw new InvalidTransactionException();
        }

        if (status == STATUS.EXECUTED) return true;
        boolean isLocked = false;
        try {

            //不直接利用单例类获取对象,因为不方便进行单元测试
            // isLocked = RedisDistributedLock.getSingletonInstance().lockTransction(id);
            //使用添加的中间层获取RedisDistributedLock对象，便于单元测试
            isLocked = lock.lock(id);

            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行 }
            }
            if (status == STATUS.EXECUTED)
                return true; // double check

            //对于有效期的测试，代码中包含跟“时间”有关的“未决行为”逻辑，我们一般的处理方式是将这种未决行为逻辑重新封装,
//            long executionInvokedTimestamp = System.currentTimestamp();
//            if (executionInvokedTimestamp - createdTimestap > 14d) {
//                this.status = STATUS.EXPIRED;
//                return false;
//            }
            // 我们只需要将交易是否过期的逻辑，封装到 isExpired() 函数中即可
            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }


            //这里直接new就不利于单元测试，依赖注入是实现代码可测试性的最有效的手段。
            //WalletRpcService walletRpcService = new WalletRpcService();

            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                // RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
                lock.unlock(id);
            }
        }
    }
}

