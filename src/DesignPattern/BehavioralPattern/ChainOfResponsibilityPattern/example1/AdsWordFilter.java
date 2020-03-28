package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/3/28
 * description: 敏感词汇过滤器
 */
public class AdsWordFilter implements SensitiveWordFilter {

    @Override
    public boolean doFilter(Content content) {
        System.out.println("i am ads word");
        return false;
    }
}