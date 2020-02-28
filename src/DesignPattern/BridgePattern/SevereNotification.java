package DesignPattern.BridgePattern;

/**
 * Created by WenTaoKing on 2020/2/28
 * description: 重要通知类
 */
public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender){
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
        System.out.println("severe notify");
    }
}
