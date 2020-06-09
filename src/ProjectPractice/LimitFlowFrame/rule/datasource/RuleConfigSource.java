package ProjectPractice.LimitFlowFrame.rule.datasource;

import ProjectPractice.LimitFlowFrame.rule.RuleConfig;

/**
 * author: WentaoKing
 * created on: 2020/6/8
 * description: 规则配置的接口
 */
public interface RuleConfigSource {

    RuleConfig load();
}
