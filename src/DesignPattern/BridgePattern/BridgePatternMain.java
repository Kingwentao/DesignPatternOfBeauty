package DesignPattern.BridgePattern;

/**
 * Created by WenTaoKing on 2020/2/28
 * description: 桥接模式的原理比较难理解，但代码实现相对简单。
 */
public class BridgePatternMain {
    public static void main(String[] args) {
        //不同紧急程度的消息和发送渠道之间的对应关系，不是在代码中固定写死的，
        // 我们可以动态地去指定（比如，通过读取配置来获取对应关系）。
        MsgSender sender = new TelephoneSender();
        Notification notification = new SevereNotification(sender);
        String msg = "紧急通知";
        notification.notify(msg);
    }
}
