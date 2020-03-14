package DesignPattern.BehavioralPattern.ObservablePattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description:
 */
public class RegNotificationObserver implements RegObserver {

    private NotificationService notificationService;

    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId,"Welcome...");
    }
}
