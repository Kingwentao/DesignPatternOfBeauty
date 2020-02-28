package DesignPattern.BridgePattern;

/**
 * Created by WenTaoKing on 2020/2/28
 * description:
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
