package DesignPattern.BehavioralPattern.StatePattern.pattern;

import DesignPattern.BehavioralPattern.StatePattern.State;

/**
 * author: WentaoKing
 * created on: 2020/3/31
 * description:
 */
public class MarioStateMachine {

    private int score;
    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return this.score;
    }

    public IMario getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }
}