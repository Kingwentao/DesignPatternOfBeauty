package practice.unittest;

/**
 * author: WentaoKing
 * created on: 2020/1/9
 * description: 使用mock方式，跳过服务器的限制，便于测试
 */
public class MockWalletRpcServiceOne extends WalletRpcService {

    @Override
    public String moveMoney(String id, Long buyerId, Long sellerId, Double amount) {
        return "123";
    }

}
