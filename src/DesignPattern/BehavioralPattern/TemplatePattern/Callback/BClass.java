package DesignPattern.BehavioralPattern.TemplatePattern.Callback;

/**
 * author: WentaoKing
 * created on: 2020/3/19
 * description:
 */
public class BClass {
    public void process(ICallback callback){
        callback.methodToCallback();
    }
}
