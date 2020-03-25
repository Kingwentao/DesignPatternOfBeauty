package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description:
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.addHandler(new HandlerC());
        chain.handle();
    }

}
