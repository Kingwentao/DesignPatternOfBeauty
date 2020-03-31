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
        this.currentState = new SmallMario(this);
    }

    public void obtainMushRoom() {
        score += 10;
        this.currentState.obtainMushRoom();
    }

    public void obtainCape() {
        score += 20;
        this.currentState.obtainCape();
    }

    public void obtainFireFlower() {
        score += 20;
        this.currentState.obtainFireFlower();
    }

    public void meetMonster() {
        score -= 20;
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