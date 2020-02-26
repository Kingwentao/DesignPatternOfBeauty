package DesignPattern.StructurePattern.ProxyPattern.StaticProxy;

import Basic1.controller.UserVo;
import DesignPattern.StructurePattern.ProxyPattern.UserController;
import practice.iterator.MetricsCollector;
import practice.iterator.MetricsStorage;
import practice.iterator.RedisMetricsStorage;
import practice.iterator.RequestInfo;

/**
 * Created by WenTaoKing on 2020/2/27
 * description:
 * Q:刚刚的代理模式的代码实现UserControllerProxy中，代理类和原始类需要实现相同的接口。
 * 但是，如果原始类并没有定义接口，并且原始类代码并不是我们开发维护的（比如它来自一个第三方的类库），
 * 我们也没办法直接修改原始类，给它重新定义一个接口,在这种情况下，我们该如何实现代理模式呢？
 * A:对于这种外部类的扩展，我们一般都是采用继承的方式。
 */
public class UserControllerProxy2 extends UserController {

    private MetricsCollector metricsCollector;

    public UserControllerProxy2() {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        //调用父类的实现，从而实现对父类的代理
        UserVo userVo = super.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        //调用父类的实现，从而实现代理
        UserVo userVo = super.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}
