package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/26
 * description:  处理器链(集合实现)
 */
public class HandlerChain2 {
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler){
       handlers.add(handler);
    }

    public void handle(){
        for (IHandler handler: handlers){
            boolean handled = handler.handle();
            if (handled){
                break;
            }
        }
    }

}
