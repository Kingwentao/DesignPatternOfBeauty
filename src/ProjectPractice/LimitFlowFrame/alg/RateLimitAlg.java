package ProjectPractice.LimitFlowFrame.alg;

/**
 * author: WentaoKing
 * created on: 2020/6/8
 * description: 限流规则算法接口
 */
public interface RateLimitAlg {

    boolean tryAcquire();
}
