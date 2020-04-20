package DesignPattern.BehavioralPattern.AnnotationPattern;

import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/4/20
 * description: 警告提示规则
 */
public class AlertRuleInterpreter {

    private Expression expression;

    public AlertRuleInterpreter(String ruleExpression) {
        this.expression = new AndExpression(ruleExpression);
    }

    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }

}
