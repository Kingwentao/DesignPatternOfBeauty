package DesignPattern.BehavioralPattern.ObservablePattern.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description: 表示 @Subscribe 注解的方法
 */
class ObserverAction {

    //观察者类
    private Object target;
    private Method method;

    ObserverAction(Object target,Method method){
     //   this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    void execute(Object event){
        try {
            method.invoke(target,event);
        }catch (InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

}
