package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.base;

import DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.base.*;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description:
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {

        // test1 :
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.addHandler(new HandlerC());
        chain.handle();

        // test 2:
        HandlerChain2 chain2 = new HandlerChain2();
        chain2.addHandler(new HandlerD());
        chain2.addHandler(new HandlerE());
        chain2.handle();
    }

}
