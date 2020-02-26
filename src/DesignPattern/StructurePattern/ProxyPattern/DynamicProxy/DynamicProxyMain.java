package DesignPattern.StructurePattern.ProxyPattern.DynamicProxy;

import DesignPattern.StructurePattern.ProxyPattern.IUserController;
import DesignPattern.StructurePattern.ProxyPattern.UserController;

/**
 * Created by WenTaoKing on 2020/2/27
 * description: 动态代理入口
 * 静态代理存在的问题：
 * 一方面，我们需要在代理类中，将原始类中的所有的方法，都重新实现一遍，并且为每个方法都附加相似的代码逻辑。
 * 另一方面，如果要添加的附加功能的类有不止一个，我们需要针对每个类都创建一个代理类。
 *
 * 我们可以使用动态代理来解决这个问题。所谓动态代理（Dynamic Proxy），
 * 就是我们不事先为每个原始类编写代理类，而是在运行的时候，动态地创建原始类对应的代理类，
 * 然后在系统中用代理类替换掉原始类。那如何实现动态代理呢？
 */

public class DynamicProxyMain {

    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        //
        String password = "jwt";
        String telephone = "12345";
        userController.login(telephone, password);
    }

}
