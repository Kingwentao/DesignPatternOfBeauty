package DesignPattern.BehavioralPattern.StatePattern;

import DesignPattern.BehavioralPattern.StatePattern.pattern.MarioStateMachine;

/**
 * author: WentaoKing
 * created on: 2020/3/31
 * description: 状态模式下的main
 */
public class StatePatternMain {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        mario.obtainCape();
        mario.obtainFireFlower();
        int score = mario.getScore();

        System.out.println("mario score: " + score + "; state: " + mario.getCurrentState().getName());
    }
}
