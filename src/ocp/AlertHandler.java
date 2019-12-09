package ocp;

/**
 * author: WentaoKing
 * created on: 2019/12/9
 * description:
 */
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;
    public AlertHandler(AlertRule rule,Notification notification){
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStateInfo apiStateInfo);
}
