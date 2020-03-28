package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/3/28
 * description:
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        SensitiveWordFilterChain filterChain = new SensitiveWordFilterChain();
        filterChain.addFilter(new PoliticalWordFilter());
        filterChain.addFilter(new SexyWordFilter());
        filterChain.addFilter(new AdsWordFilter());

        boolean legal = filterChain.filter(new Content());
        if (!legal) { // 不发表
            System.out.println("存在敏感词汇");
        } else {
            System.out.println("不存在敏感词汇");
        }

    }
}
