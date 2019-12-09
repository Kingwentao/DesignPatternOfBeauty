package ocp;

/**
 * author: WentaoKing
 * created on: 2019/12/9
 * description:
 */
public class ErrorAlertHandler extends AlertHandler {

    ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStateInfo apiStateInfo) {
        if (apiStateInfo.getErrorCount() > rule.getMatchedRule(apiStateInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
