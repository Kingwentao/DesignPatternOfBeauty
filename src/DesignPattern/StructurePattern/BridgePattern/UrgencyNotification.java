package DesignPattern.StructurePattern.BridgePattern;

/**
 * Created by WenTaoKing on 2020/2/28
 * description:
 */
public class UrgencyNotification extends Notification {

    public UrgencyNotification(MsgSender msgSender){
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
        System.out.println("urgency notify");
    }
}
