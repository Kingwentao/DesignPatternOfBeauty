package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/3/28
 * description: sexy相关的敏感词
 */
public class SexyWordFilter implements SensitiveWordFilter {

    @Override
    public boolean doFilter(Content content) {
        System.out.println("exist sexy word");
        return true;
    }
}
