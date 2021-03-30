package DesignPattern.StructurePattern.ProxyPattern.DynamicProxy;

import practice.iterator.MetricsCollector;
import practice.iterator.RedisMetricsStorage;
import practice.iterator.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by WenTaoKing on 2020/2/27
 * description: 动态代理实现
 * <p>
 * 代理类的核心：它在不改变原始类（或叫被代理类）代码的情况下，通过引入代理类来给原始类附加功能。
 * 动态代理（Dynamic Proxy），就是我们不事先为每个原始类编写代理类，而是在运行的时候，动态地创建原始类对应的代理类，然后在系统中用代理类替换掉原始类
 */
public class MetricsCollectorProxy {

    private final MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    //为什么要用object？
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        ClassLoader classLoader = proxiedObject.getClass().getClassLoader();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private final Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //1.执行原始类前的附加功能
            long startTimestamp = System.currentTimeMillis();
            System.out.println("proxy method before...");
            //2.执行原始类的功能
            Object result = method.invoke(proxiedObject, args);
            //3.执行原始类后的附加功能
            System.out.println("proxy method after...");
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            //查找调用原始的类方法
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            System.out.println("proxy api name: " + apiName);
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }

}
