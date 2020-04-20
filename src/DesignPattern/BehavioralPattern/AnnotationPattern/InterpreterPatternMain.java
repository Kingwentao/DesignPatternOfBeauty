package DesignPattern.BehavioralPattern.AnnotationPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/4/20
 * description: 解释器模式
 * 为某个语言定义它的语法（或者叫文法）表示，并定义一个解释器用来处理这个语法。
 * 它的代码实现的核心思想，就是将语法解析的工作拆分到各个小类中，
 * 以此来避免大而全的解析类。一般的做法是，将语法规则拆分一些小的独立的单元，然后对每个单元进行解析，最终合并为对整个语法规则的解析。
 *
 */
public class InterpreterPatternMain {
    public static void main(String[] args) {
        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String,Long> stats = new HashMap<>();
        stats.put("key1", 10l);
        stats.put("key2", 10l);
        stats.put("key3", 12l);
        stats.put("key4", 89l);
        boolean alert = interpreter.interpret(stats);
        System.out.println(alert);
    }
}
