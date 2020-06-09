package ProjectPractice.LimitFlowFrame;

import ProjectPractice.LimitFlowFrame.alg.FixedTimeWinRateLimitAlg;
import ProjectPractice.LimitFlowFrame.alg.RateLimitAlg;
import ProjectPractice.LimitFlowFrame.rule.ApiLimit;
import ProjectPractice.LimitFlowFrame.rule.RateLimitRule;
import ProjectPractice.LimitFlowFrame.rule.TrieRateLimitRule;
import ProjectPractice.LimitFlowFrame.rule.RuleConfig;
import ProjectPractice.LimitFlowFrame.rule.datasource.FileRuleConfigSource;
import ProjectPractice.LimitFlowFrame.rule.datasource.RuleConfigSource;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * author: WentaoKing
 * created on: 2020/6/3
 * description:  串联整个限流流程,提供用户直接使用的最顶层接口（limit() 接口）
 */
public class RateLimiter {
    private static final Logger log = Logger.getLogger("RateLimiter");
    //为每个api在内存中存储限流计数器
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap();
    private RateLimitRule rule;

    public RateLimiter() {
        //将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new TrieRateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) throws InternalException {
        //获取限流规则api
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            FixedTimeWinRateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit());
            //putIfAbsent: 传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }
        return rateLimitCounter.tryAcquire();
    }
}
