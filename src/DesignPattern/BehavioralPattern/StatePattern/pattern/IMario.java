package DesignPattern.BehavioralPattern.StatePattern.pattern;

import DesignPattern.BehavioralPattern.StatePattern.State;

/**
 * author: WentaoKing
 * created on: 2020/3/31
 * description: 状态类接口
 */
public interface IMario {
    State getName();

    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlower();

    void meetMonster();

}
