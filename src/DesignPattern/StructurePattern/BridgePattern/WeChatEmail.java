package DesignPattern.StructurePattern.BridgePattern;

/**
 * Created by WenTaoKing on 2020/2/28
 * description:
 */
public class WeChatEmail implements MsgSender{

    @Override
    public void send(String message) {
        System.out.println("send weChat msg");
    }
}
