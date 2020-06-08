package ProjectPractice.LimitFlowFrame.rule;

/**
 * author: WentaoKing
 * created on: 2020/6/3
 * description: 限流规则：一个支持快速查询的数据结构
 *
 * 限流过程中会频繁地查询接口对应的限流规则，为了尽可能地提高查询速度，
 * 我们需要将限流规则组织成一种支持按照 URL 快速查询的数据结构。考虑到 URL 的重复度比较高，且需要按照前缀来匹配
 */
public class TrieRateLimitRule {

    public TrieRateLimitRule(RuleConfig ruleConfig) {

    }

    public ApiLimit getLimit(String appId, String url) {
        return null;
    }
}
