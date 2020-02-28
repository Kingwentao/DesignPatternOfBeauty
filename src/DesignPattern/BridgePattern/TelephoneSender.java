package DesignPattern.BridgePattern;

import java.util.List;

/**
 * Created by WenTaoKing on 2020/2/28
 * description:
 */
public class TelephoneSender implements MsgSender {

    private List<String> phoneListener;
    @Override
    public void send(String message) {
        System.out.println("send telephone msg : " + message);
    }
}
