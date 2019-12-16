package Basic2.service;

import Basic2.exception.NoSufficientBalanceException;
import Basic2.repository.*;

import java.math.BigDecimal;

/**
 * author: WentaoKing
 * created on: 2019/11/29
 * description: 虚拟钱包的业务逻辑
 */
public class VirtualWalletService {

    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity);
        return walletBo;
    }

    private VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
        return null;
    }

    public BigDecimal getBalance(Long walletId) {
      //  return virtualWalletRepo.getBalance(walletId);
        return null;
    }

    /**
     * 出账
     * @param walletId 钱包id
     * @param amount 出账额
     */
    public void debit(Long walletId, BigDecimal amount) throws NoSufficientBalanceException {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
          //  throw new NoSufficientBalanceException();
        }
        walletRepo.updateBalance(walletId, balance.subtract(amount));
    }

    /**
     * 入账
     * @param walletId 钱包i
     * @param amount 入账额
     */
    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        walletRepo.updateBalance(walletId, balance.add(amount));
    }

    /**
     * 交易
     * @param fromWalletId
     * @param toWalletId
     * @param amount
     */
//    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
//        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
//        transactionEntity.setAmount(amount);
//        transactionEntity.setCreateTime(System.currentTimeMillis());
//        transactionEntity.setFromWalletId(fromWalletId);
//        transactionEntity.setToWalletId(toWalletId);
//        transactionEntity.setStatus(Status.TO_BE_EXECUTED);
//        Long transactionId = transactionRepo.saveTransaction(transactionEntity);
//        try {
//            debit(fromWalletId, amount);
//            credit(toWalletId, amount);
//        } catch (InsufficientBalanceException e) {
//            transactionRepo.updateStatus(transactionId, Status.CLOSED); ...rethrow exception e...} catch (Exception e) {
//            transactionRepo.updateStatus(transactionId, Status.FAILED); ...rethrow exception e...}
//        transactionRepo.updateStatus(transactionId, Status.EXECUTED);
//    }
}
