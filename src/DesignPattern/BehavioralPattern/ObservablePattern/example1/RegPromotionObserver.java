package DesignPattern.BehavioralPattern.ObservablePattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description: 具体的观察者
 */
public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
