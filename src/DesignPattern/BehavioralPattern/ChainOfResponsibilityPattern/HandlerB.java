package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: B处理器
 */
public class HandlerB extends Handler {
    @Override
    public void handle() {
        System.out.println("i am a handler B");
        boolean handled = false;
        //

        if (!handled && successor!=null){
            successor.handle();
        }
    }
}
