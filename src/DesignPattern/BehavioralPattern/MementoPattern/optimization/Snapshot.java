package DesignPattern.BehavioralPattern.MementoPattern.optimization;

/**
 * author: WentaoKing
 * created on: 2020/4/14
 * description: 定义一个独立的类（Snapshot 类）来表示快照，
 * 而不是复用 InputText 类。这个类只暴露 get() 方法，没有 set() 等任何修改内部状态的方法
 */
public class Snapshot {

    private String text;

    public Snapshot(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
