package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: C处理器
 */
public class HandlerC extends Handler {
    @Override
    public void handle() {
        System.out.println("i am a handler C");
        boolean handled = false;
        //
        if (!handled && successor!=null){
            successor.handle();
        }
    }
}
