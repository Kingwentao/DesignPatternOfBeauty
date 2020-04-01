package DesignPattern.BehavioralPattern.StatePattern.pattern;

import DesignPattern.BehavioralPattern.StatePattern.State;

/**
 * author: WentaoKing
 * created on: 2020/3/31
 * description:
 */
public class SmallMario implements IMario {

    private static final SmallMario instance = new SmallMario();

    private SmallMario() {
    }

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() - 300);
    }

}
