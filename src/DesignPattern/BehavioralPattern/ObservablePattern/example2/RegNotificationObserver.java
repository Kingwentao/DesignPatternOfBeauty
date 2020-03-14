package DesignPattern.BehavioralPattern.ObservablePattern.example2;

import DesignPattern.BehavioralPattern.ObservablePattern.eventbus.Subscribe;
import DesignPattern.BehavioralPattern.ObservablePattern.example1.NotificationService;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description:
 */
public class RegNotificationObserver {

    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(long userId){
        notificationService.sendInboxMessage(userId,"hhh");
    }

}
