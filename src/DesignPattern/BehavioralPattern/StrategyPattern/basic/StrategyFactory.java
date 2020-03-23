package DesignPattern.BehavioralPattern.StrategyPattern.basic;

import DesignPattern.BehavioralPattern.StrategyPattern.basic.ConcreteStrategyA;
import DesignPattern.BehavioralPattern.StrategyPattern.basic.ConcreteStrategyB;
import DesignPattern.BehavioralPattern.StrategyPattern.basic.Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/3/21
 * description: 创建策略对象工厂类（针对无状态的策略，不包含成员变量，只是纯粹的算法实现
 * 这样的策略对象是可以共享，就可以通过下面的实现方式把所有策略对象先缓存到内存中，用的时候直接返回）
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A",new ConcreteStrategyA());
        strategies.put("B",new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty!");
        }
        return strategies.get(type);
    }

}
