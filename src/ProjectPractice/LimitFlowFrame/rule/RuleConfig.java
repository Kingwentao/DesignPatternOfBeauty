package ProjectPractice.LimitFlowFrame.rule;

import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/6/3
 * description: 限流规则配置
 * RuleConfig 类嵌套了另外两个类 AppRuleConfig 和 ApiLimit。这三个类跟配置文件的三层嵌套结构完全对应
 */
public class RuleConfig {
    private List<AppRuleConfig> configs;

    public List<AppRuleConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<AppRuleConfig> configs) {
        this.configs = configs;
    }

    public static class AppRuleConfig {
        private String appId;
        private List<ApiLimit> limits;

        AppRuleConfig() {
        }

        AppRuleConfig(String appId, List<ApiLimit> limits) {
            this.appId = appId;
            this.limits = limits;
        }
    }

    public class ApiLimit {
        private static final int DEFAULT_TIME_UNIT = 1; // 1 second
        private String api;
        private int limit;
        private int unit = DEFAULT_TIME_UNIT;

        ApiLimit() {
        }

        ApiLimit(String api, int limit) {
            this(api, limit, DEFAULT_TIME_UNIT);
        }

        public ApiLimit(String api, int limit, int unit) {
            this.api = api;
            this.limit = limit;
            this.unit = unit;
        }
    }

}
