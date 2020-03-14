package DesignPattern.BehavioralPattern.ObservablePattern.example1;


import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description: 控制类，对注册的用户进行操作  发送的信息（被观察者）  -》 注册的用户（观察者）
 */
public class UserController {

    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {

        long userId = userService.register(telephone, password);

        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }
}
