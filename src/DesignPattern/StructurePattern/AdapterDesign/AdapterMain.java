package DesignPattern.StructurePattern.AdapterDesign;

/**
 * author: WentaoKing
 * created on: 2020/3/3
 * description: 适配器模式入口
 */
public class AdapterMain {
    public static void main(String[] args) {

        //类适配器:
        ITarget target = new Adaptor();
        target.f1();

        //对象适配器:
        Adaptee adaptee = new Adaptee();
        ITarget target2 = new Adaptor2(adaptee);
        target2.f1();

        /**
         * 对于两种实现方式的取舍：
         * 1. 如果 Adaptee 接口并不多，那两种实现方式都可以
         * 2. 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都相同，
         * 那我们推荐使用类适配器，因为 Adaptor 复用父类 Adaptee 的接口，比起对象适配器的实现方式，Adaptor 的代码量要少一些。
         * 3. 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都不相同，
         * 那我们推荐使用对象适配器，因为组合结构相对于继承更加灵活。
         */

        //3.替换依赖的外部系统
        //借助BAdaptor，Demo的代码中，调用IA接口的地方都无需改动
        //只需要将BAdaptor如下注入到Demo即可
        Demo d = new Demo(new BAdapter(new B()));

        //4.兼容老版本的接口

    }
}