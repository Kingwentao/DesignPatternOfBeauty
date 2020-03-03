package DesignPattern.StructurePattern.AdapterDesign;

/**
 * author: WentaoKing
 * created on: 2020/3/3
 * description: 对象适配器：基于组合
 */
public class Adaptor2 implements ITarget{

    private Adaptee adaptee;

    public Adaptor2(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {

    }

    @Override
    public void fc() {
        //和类适配器不同：需要通过注入的对象去调用fc
        adaptee.fc();
    }
}
