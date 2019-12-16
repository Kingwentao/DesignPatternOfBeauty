package BasicPrincple.isp;

import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2019/12/16
 * description: 暴露给外面的配置信息接口
 */
public interface Viewer {
    String outputInPlainText();

    Map<String,String> output();
}
