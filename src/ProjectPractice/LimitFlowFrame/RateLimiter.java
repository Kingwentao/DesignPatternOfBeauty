package ProjectPractice.LimitFlowFrame;

import ProjectPractice.LimitFlowFrame.alg.FixedTimeWinRateLimitAlg;
import ProjectPractice.LimitFlowFrame.rule.ApiLimit;
import ProjectPractice.LimitFlowFrame.rule.TrieRateLimitRule;
import ProjectPractice.LimitFlowFrame.rule.RuleConfig;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author: WentaoKing
 * created on: 2020/6/3
 * description:  串联整个限流流程,提供用户直接使用的最顶层接口（limit() 接口）
 */
public class RateLimiter {
    private static final Logger log = Logger.getLogger("RateLimiter");
    //为每个api在内存中存储限流计数器
    private ConcurrentHashMap<String, FixedTimeWinRateLimitAlg> counters = new ConcurrentHashMap();
    private TrieRateLimitRule rule;

    public RateLimiter(){
        //将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try{
            in = getClass().getResourceAsStream("/ratelimiter-rule.yaml");
            if (in != null){
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        }finally {
            if (in != null){
                try {
                    in.close();
                }catch (IOException e){
                    log.log(Level.INFO,"close file error:{}");
                }
            }
        }
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
       this.rule = new TrieRateLimitRule(ruleConfig);
    }

    public boolean limit(String appId,String url) throws InternalException{
        //获取限流规则api
        ApiLimit apiLimit = rule.getLimit(appId,url);
        if (apiLimit == null){
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        FixedTimeWinRateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null){
            FixedTimeWinRateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit());
            //putIfAbsent: 传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
            rateLimitCounter = counters.putIfAbsent(counterKey,newRateLimitCounter);
            if (rateLimitCounter == null){
                rateLimitCounter = newRateLimitCounter;
            }
        }
        return rateLimitCounter.tryAcquire();
    }
}
