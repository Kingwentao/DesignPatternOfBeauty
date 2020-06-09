package ProjectPractice.LimitFlowFrame.rule;

/**
 * author: WentaoKing
 * created on: 2020/6/8
 * description: 限流规则的接口
 */
public interface RateLimitRule {

    ApiLimit getLimit(String appId, String url);
}
