package DesignPattern.BehavioralPattern.ObservablePattern.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: WentaoKing
 * created on: 2020/3/14
 * description: 标明观察者中的哪个函数可以接收消息
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

}
