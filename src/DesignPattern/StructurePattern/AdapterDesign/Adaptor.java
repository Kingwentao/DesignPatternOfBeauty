package DesignPattern.StructurePattern.AdapterDesign;

/**
 * author: WentaoKing
 * created on: 2020/3/3
 * description: 类适配器：基于继承
 */
public class Adaptor extends Adaptee implements ITarget{

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        //重新实现
    }

    //这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点

}
