package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.base;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: C处理器
 */
public class HandlerC extends Handler {
    @Override
    public boolean doHandle() {
        System.out.println("i am a handler C");
        boolean handled = false;
        return handled;
    }
}
