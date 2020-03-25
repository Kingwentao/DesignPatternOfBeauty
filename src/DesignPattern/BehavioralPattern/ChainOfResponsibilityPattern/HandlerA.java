package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: A处理器
 */
public class HandlerA extends Handler {
    @Override
    public void handle() {
        System.out.println("i am a handler A");
        boolean handled = false;
        //
        if (!handled && successor!=null){
            successor.handle();
        }
    }
}
