package DesignPattern.BehavioralPattern.ObservablePattern.eventbus;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description:  EventBus 实现的是阻塞同步的观察者模式
 */
public class EventBus {

    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus(){
        //MoreExecutors.directExecutor() 是 Google Guava 提供的工具类，看似是多线程，实际上是单线程
       // this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor){
        this.executor = executor;
    }

    public void register(Object object){
        registry.register(object);
    }

    public void post(Object event){
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction: observerActions){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
