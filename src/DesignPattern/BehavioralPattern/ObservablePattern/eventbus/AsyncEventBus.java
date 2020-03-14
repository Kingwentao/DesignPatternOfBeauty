package DesignPattern.BehavioralPattern.ObservablePattern.eventbus;

import java.util.concurrent.Executor;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description: 异步非阻塞的观察者模式
 */
public class AsyncEventBus extends EventBus {

    //调用者注入线程池。
    public AsyncEventBus(Executor executor){
        super(executor);
    }
}
