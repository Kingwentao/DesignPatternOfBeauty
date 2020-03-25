package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: 所有处理器的抽象父类
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handle();
}
