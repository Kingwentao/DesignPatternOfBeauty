package ProjectPractice.LimitFlowFrame.rule.parser;

import ProjectPractice.LimitFlowFrame.rule.RuleConfig;

import java.io.InputStream;

/**
 * author: WentaoKing
 * created on: 2020/6/8
 * description:
 */
public interface RuleConfigParser {

    RuleConfig parser(InputStream inputStream);
}
