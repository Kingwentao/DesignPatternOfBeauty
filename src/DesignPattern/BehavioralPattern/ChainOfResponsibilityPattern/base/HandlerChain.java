package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.base;

/**
 * author: WentaoKing
 * created on: 2020/3/25
 * description: 处理器链(链表实现)
 */
public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    /**
     * 添加处理器
     * @param handler
     */
    void addHandler(Handler handler){
        handler.setSuccessor(null);
        if (head == null){
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    void handle(){
        if (head!=null){
            head.handle();
        }
    }

}
