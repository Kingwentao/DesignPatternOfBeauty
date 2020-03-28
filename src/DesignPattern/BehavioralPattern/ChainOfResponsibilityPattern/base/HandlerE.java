package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.base;

/**
 * author: WentaoKing
 * created on: 2020/3/26
 * description:
 */
public class HandlerE implements IHandler {
    @Override
    public boolean handle() {
        System.out.println("i am a handler E");
        return false;
    }
}
