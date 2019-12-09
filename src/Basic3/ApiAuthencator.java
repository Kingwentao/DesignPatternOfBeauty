package Basic3;

/**
 * author: WentaoKing
 * created on: 2019/12/4
 * description: 鉴权系统的暴露接口
 */
public interface ApiAuthencator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
