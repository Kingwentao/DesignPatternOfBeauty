package DesignPattern.BehavioralPattern.StatePattern.pattern;

import DesignPattern.BehavioralPattern.StatePattern.State;

/**
 * author: WentaoKing
 * created on: 2020/4/1
 * description: 斗篷马里奥
 */
public class CapMario implements IMario {

    private static final CapMario instance = new CapMario();

    private CapMario(){ }

    public static CapMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() - 200);
        stateMachine.setCurrentState(SmallMario.getInstance());
    }
}
