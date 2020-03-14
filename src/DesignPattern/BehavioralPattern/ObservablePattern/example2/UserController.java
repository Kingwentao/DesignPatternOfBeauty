package DesignPattern.BehavioralPattern.ObservablePattern.example2;


import DesignPattern.BehavioralPattern.ObservablePattern.eventbus.AsyncEventBus;
import DesignPattern.BehavioralPattern.ObservablePattern.eventbus.EventBus;
import DesignPattern.BehavioralPattern.ObservablePattern.example1.UserService;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description: 使用EventBus 框架实现观察者模式
 */
public class UserController {
    private UserService userService;

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController(){
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers){
        //注册观察者
        for (Object observer: observers){
            eventBus.register(observer);
        }
    }

    public Long register(String telephone,String password) {
        long userId = userService.register(telephone,password);
        eventBus.post(userId);
        return userId;
    }

}
