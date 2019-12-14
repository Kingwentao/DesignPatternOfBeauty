package BasicPrincple.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2019/12/9
 * description:
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler){
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStateInfo apiStateInfo){
        for (AlertHandler handler: alertHandlers){
            handler.check(apiStateInfo);
        }
    }
}
