package practice.unittest;

import javax.transaction.InvalidTransactionException;

/**
 * author: WentaoKing
 * created on: 2020/1/9
 * description:
 * ，如果代码中依赖了外部系统或者不可控组件，
 * 比如，需要依赖数据库、网络通信、文件系统等，那我们就需要将被测代码与外部系统解依赖，
 * 而这种解依赖的方法就叫作“mock”。所谓的 mock 就是用一个“假”的服务替换真正的服务。mock 的服务完全在我们的控制之下，模拟输出我们想要的数据。
 */

public class TransactionTest {

    public static void main(String[] args) {

    }

    public void testExecute() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        boolean executedResult = transaction.execute();
       // assertTrue(executedResult);
    }

    //使用mock一个新类，通过注入的方式绕过一些限制直接进行单元测试
    public void testExecute2() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        WalletRpcService walletRpcService = new MockWalletRpcServiceOne();
        Transaction transaction = new Transaction( null, buyerId, sellerId, productId, orderId);
        //注入mock对象。绕过负载的限制
        transaction.setWalletRpcService(walletRpcService);
        boolean executedResult = transaction.execute();
       // assertTrue(executedResult);
    }

    /**
     * 通过添加一层TransactionLock来解决单例类不能被 mock（无法继承和重写方法），也无法通过依赖注入的方式来替换。
     * @throws InvalidTransactionException
     */
    public void testExecute3() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        //使用添加的中间层来mock TransactionLock的行为
        TransactionLock transactionLock = new TransactionLock(){
            public boolean lock(String id){
                return  true;
            }

            public void unlock(){ }
        };

        Transaction transaction = new Transaction( null, buyerId, sellerId, productId, orderId);
        transaction.setTransactionLock(transactionLock);
        boolean executedResult = transaction.execute();
        // assertTrue(executedResult);
        //assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    public void testExecute4() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;


        Transaction transaction = new Transaction( null, buyerId, sellerId, productId, orderId){
            @Override
            protected boolean isExpired() {
                return true;
            }
        };

        boolean executedResult = transaction.execute();
        // assertTrue(executedResult);
        //assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }
}
