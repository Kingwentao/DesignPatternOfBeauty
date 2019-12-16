package BasicPrincple.isp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2019/12/16
 * description:
 */
public class SimpleHttpServer {
    private String host;
    private int port;
    private Map<String, List<Viewer>> viewers =new HashMap<>();

    SimpleHttpServer(String host,int port){
    }

    public void addViewers(String urlDirectory,Viewer viewer){
        if (!viewers.containsKey(urlDirectory)){
            viewers.put(urlDirectory,new ArrayList<Viewer>());
        }
        this.viewers.get(urlDirectory).add(viewer);
    }

    public void run(){
        System.out.println("http server is running");
        //把需要展示的View
        for (List<Viewer> viewer: viewers.values()){
            System.out.println("http server is running" + viewer);
            for (Viewer v : viewer){
                v.outputInPlainText();
            }
        }
    }
}
