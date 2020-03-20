package DesignPattern.BehavioralPattern.TemplatePattern.Hook;

import BasicPrincple.isp.Application;

/**
 * author: WentaoKing
 * created on: 2020/3/20
 * description:
 */
public class Runtime{

    private Runtime(){}

    public static Runtime mRuntime = null;

    public void addShutdownHook(Thread hook) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("shutdownHooks"));
        }
        ApplicationShutdownHooks.add(hook);

    }

    public static Runtime getRuntime() {
       if (mRuntime == null ) {
           mRuntime = new Runtime();
       }
       return mRuntime;
    }

}
