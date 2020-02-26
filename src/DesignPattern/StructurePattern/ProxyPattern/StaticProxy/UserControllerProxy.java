package DesignPattern.StructurePattern.ProxyPattern.StaticProxy;

import Basic1.controller.UserVo;
import DesignPattern.StructurePattern.ProxyPattern.IUserController;
import DesignPattern.StructurePattern.ProxyPattern.UserController;
import practice.iterator.MetricsCollector;
import practice.iterator.RequestInfo;

/**
 * Created by WenTaoKing on 2020/2/27
 * description: 用户行为控制的代理类，代理UserController类的行为
 */
public class UserControllerProxy implements IUserController {

    private MetricsCollector metricsCollector;
    private UserController mUserController;

    public UserControllerProxy(UserController userController){
        this.mUserController = userController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        // 委托
        UserVo userVo = mUserController.login(telephone, password);
        long startTimestamp = System.currentTimeMillis();
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        // 委托
        UserVo userVo = mUserController.register(telephone, password);
        long startTimestamp = System.currentTimeMillis();
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}
