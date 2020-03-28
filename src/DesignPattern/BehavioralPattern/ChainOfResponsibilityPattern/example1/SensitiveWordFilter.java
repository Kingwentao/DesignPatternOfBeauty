package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/3/28
 * description: 敏感词汇过滤器
 */
public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
