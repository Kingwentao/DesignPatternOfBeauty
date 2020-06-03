package ProjectPractice.LimitFlowFrame;

import ProjectPractice.LimitFlowFrame.alg.RateLimitAlg;
import ProjectPractice.LimitFlowFrame.rule.RateLimitRule;
import ProjectPractice.LimitFlowFrame.rule.RuleConfig;

import java.io.IOException;
import java.io.InputStream;
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
    private ConcurrentHashMap<String,RateLimitAlg> counter = new ConcurrentHashMap();
    private RateLimiter rule;

    public RateLimiter(){
        //将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try{

        }catch (IOException e){
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

                }
            }
        }
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
       this.rule = new RateLimitRule(ruleConfig);
    }
}
