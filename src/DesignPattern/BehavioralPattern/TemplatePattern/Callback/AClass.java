package DesignPattern.BehavioralPattern.TemplatePattern.Callback;

/**
 * author: WentaoKing
 * created on: 2020/3/19
 * description: callBack 也有复用和扩展的能力
 * 如果 ICallback、BClass 类是框架代码，AClass 是使用框架的客户端代码，
 * 我们可以通过 ICallback 定制 process() 函数
 *
 * 回调： 同步回调和异步回调
 * 同步回调： 函数返回之前执行回调函数   ---》 模版模式
 * 异步回调（延迟回调）：函数返回之后执行回调函数  --》 观察者模式
 */
public class AClass {

    public static void main(String[] args) {
        BClass b = new BClass();
        //1. 调用process函数 -- 就可以复用process的代码
        //在 process() 函数返回之前，执行完回调函数 methodToCallback()
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                //2. 等callback回调后再添加代码等同于扩展process的功能
                System.out.println("Call back me");
            }
        });
    }
}
