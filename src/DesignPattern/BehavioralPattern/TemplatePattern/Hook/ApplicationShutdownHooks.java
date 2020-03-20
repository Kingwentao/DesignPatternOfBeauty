package DesignPattern.BehavioralPattern.TemplatePattern.Hook;

import java.util.Collection;
import java.util.IdentityHashMap;

/**
 * author: WentaoKing
 * created on: 2020/3/20
 * description: Hook 比较经典的应用场景是 Tomcat 和 JVM 的 shutdown hook
 */
public class ApplicationShutdownHooks {
    private static IdentityHashMap<Thread,Thread> hooks;

    static {

        try {
            hooks = new IdentityHashMap<>();
        } catch (IllegalStateException e) {
            hooks = null;
        }
    }

    static synchronized void add(Thread hook) {
        if (hooks == null) throw new IllegalStateException("Shutdown in progress");
        if (hook.isAlive()) throw new IllegalArgumentException("Hook already running");
        if (hooks.containsKey(hook)) throw new IllegalArgumentException("Hook previously registered");
        hooks.put(hook, hook);
    }

    static void runHooks() {
        Collection<Thread> threads;
        synchronized (ApplicationShutdownHooks.class) {
            threads = hooks.keySet();
            hooks = null;
        }
        for (Thread hook : threads) {
            hook.start();
        }
        for (Thread hook : threads) {
            while (true) {
                try {
                    hook.join();
                    break;
                } catch (InterruptedException ignored) {

                }
            }
        }
    }
}