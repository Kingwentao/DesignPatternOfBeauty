package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: 处理器链
 */
public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    /**
     * 添加处理器
     * @param handler
     */
    public void addHandler(Handler handler){
        handler.setSuccessor(null);
        if (head == null){
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(){
        if (head!=null){
            head.handle();
        }
    }

}
