package DesignPattern.BehavioralPattern.TemplatePattern.Hook;

/**
 * author: WentaoKing
 * created on: 2020/3/20
 * description:
 */
public class ShutDownHookDemo {

    static class ShutdownHook extends Thread{
        @Override
        public void run() {
            System.out.println("I am called during shutting down");
        }
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
}
