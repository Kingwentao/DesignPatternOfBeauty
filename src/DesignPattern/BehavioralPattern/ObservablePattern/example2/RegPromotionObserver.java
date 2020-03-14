package DesignPattern.BehavioralPattern.ObservablePattern.example2;

import DesignPattern.BehavioralPattern.ObservablePattern.eventbus.Subscribe;
import DesignPattern.BehavioralPattern.ObservablePattern.example1.PromotionService;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description:
 */
public class RegPromotionObserver {

    private PromotionService promotionService;

    @Subscribe
    public void handleRegSuccess(long userId){
        promotionService.issueNewUserExperienceCash(userId);
    }

}
