package DesignPattern.BehavioralPattern.StrategyPattern.basic;

import DesignPattern.BehavioralPattern.StrategyPattern.basic.ConcreteStrategyA;
import DesignPattern.BehavioralPattern.StrategyPattern.basic.ConcreteStrategyB;
import DesignPattern.BehavioralPattern.StrategyPattern.basic.Strategy;

/**
 * author: WentaoKing
 * created on: 2020/3/21
 * description:创建策略对象工厂类（针对有状态的策略类，需要根据业务场景需要，希望从工厂方法中获得的都是新创建的策略对象，
 *              而不是缓存好可共享的策略对象）
 */
public class StrategyFactory2 {

    public static Strategy getStrategy(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty!");
        }

        if (type.equals("A")){
            return new ConcreteStrategyA();
        }else if(type.equals("B")){
           return new ConcreteStrategyB();
        }
        return null;
    }

}
