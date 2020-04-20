package DesignPattern.BehavioralPattern.AnnotationPattern;

import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/4/20
 * description:
 */
public interface Expression {
    boolean interpret(Map<String, Long> stats);
}
