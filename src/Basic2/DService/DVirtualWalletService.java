package Basic2.DService;

import Basic2.repository.VirtualWalletEntity;
import Basic2.repository.VirtualWalletRepository;
import Basic2.repository.VirtualWalletTransactionRepository;

import java.math.BigDecimal;

/**
 * author: WentaoKing
 * created on: 2019/12/2
 * description: DDD开发模式下的service层
 *
 * DDD模式下service不负责主要的业务逻辑，那它的指责是什么呢？
 * 1.Service 类负责与 Repository 交流。在我的设计与代码实现中，VirtualWalletService 类负责与 Repository 层打交道，
 * 调用 Respository 类的方法，获取数据库中的数据，转化成领域模型 VirtualWallet，
 * 然后由领域模型 VirtualWallet 来完成业务逻辑，最后调用 Repository 类的方法，将数据存回数据库。
 * (之所以让 VirtualWalletService 类与 Repository 打交道，而不是让领域模型 VirtualWallet 与 Repository 打交道，
 * 那是因为我们想保持领域模型的独立性，不与任何其他层的代码（Repository 层的代码）或开发框架（比如 Spring、MyBatis）耦合在一起，
 * 将流程性的代码逻辑（比如从 DB 中取数据、映射数据）与领域模型的业务逻辑解耦，让领域模型更加可复用)
 * 2.Service 类负责跨领域模型的业务聚合功能。VirtualWalletService 类中的 transfer() 转账函数会涉及两个钱包的操作，
 * 因此这部分业务逻辑无法放到 VirtualWallet 类中，所以，我们暂且把转账业务放到 VirtualWalletService 类中。后期如果转账业务变复杂可以
 * 单独抽出来
 * 3.负责一些非功能性及与三方系统交互的工作。比如幂等、事务、发邮件、发消息、记录日志、调用其他系统的 RPC 接口等，都可以放到 Service 类中。
 */
public class DVirtualWalletService {
    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    /**
     * 获取虚拟钱包
     * @param walletId
     * @return
     */
    public VirtualWallet getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        return wallet;
    }

    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.debit(amount);
        walletRepo.updateBalance(walletId, wallet.balance());
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.credit(amount);
        walletRepo.updateBalance(walletId, wallet.balance());
    }

    private VirtualWallet convert(VirtualWalletEntity walletEntity) {
        return null;
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        //...跟基于贫血模型的传统开发模式的代码一样...

    }
}
