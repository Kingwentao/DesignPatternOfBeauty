package DesignPattern.BehavioralPattern.StatePattern;

/**
 * author: WentaoKing
 * created on: 2020/3/31
 * description: 状态枚举类
 */
public enum State {

    SMALL(0), SUPER(1), FIRE(2), CAPE(3);

    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
