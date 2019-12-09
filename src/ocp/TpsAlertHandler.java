package ocp;

/**
 * author: WentaoKing
 * created on: 2019/12/9
 * description:
 */
public class TpsAlertHandler extends AlertHandler {

    TpsAlertHandler(AlertRule rule,Notification notification){
        super(rule,notification);
    }

    @Override
    public void check(ApiStateInfo apiStateInfo) {
        long tps = apiStateInfo.getRequestCount() / apiStateInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStateInfo.getApi()).getMaxTps()){
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
