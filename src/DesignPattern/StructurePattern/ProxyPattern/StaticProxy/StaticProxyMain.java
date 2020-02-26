package DesignPattern.StructurePattern.ProxyPattern.StaticProxy;

import DesignPattern.StructurePattern.ProxyPattern.IUserController;
import DesignPattern.StructurePattern.ProxyPattern.StaticProxy.UserControllerProxy;
import DesignPattern.StructurePattern.ProxyPattern.StaticProxy.UserControllerProxy2;
import DesignPattern.StructurePattern.ProxyPattern.UserController;

/**
 * Created by WenTaoKing on 2020/2/27
 * description: 静态代理入口
 */
public class StaticProxyMain {
    public static void main(String[] args) {

        //1.因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        // 将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        IUserController userController = new UserControllerProxy(new UserController());

        //调用代理的方法
        String password = "jwt";
        String telephone = "12345";
        userController.login(telephone, password);

        //2.对于原始类没有实现接口，就不能使用1中的方法实现面向接口的代理
        //对于这种外部类的扩展，我们一般都是采用继承的方式。
        UserController userController2 = new UserControllerProxy2();
        userController2.login(telephone,password);

    }
}
