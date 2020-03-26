package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/26
 * description:
 */
public class HandlerD implements  IHandler {
    @Override
    public boolean handle() {
        System.out.println("i am a handler D");
        return true;
    }
}
