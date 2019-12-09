package Basic3;

/**
 * author: WentaoKing
 * created on: 2019/12/4
 * description: 1.token apiId timeStamp -> url
 */
public class DefaultApiAufthencatorImpl implements ApiAuthencator {
    private CredentialStorage credentialStorage;

    public DefaultApiAufthencatorImpl() {
        this.credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultApiAufthencatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        //根据调用方的url
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getOriginalUrl();
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        //根据时间戳判断 token 是否过期失效；
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }
        //从存储中取出 AppID 和对应的密码
        String password = credentialStorage.getPasswordByAppId(appId);
        //取出 AppID 对应的密码，通过同样的 token 生成算法，生成另外一个 token
        AuthToken serverAuthToken = AuthToken.generate(originalUrl, appId, password, timestamp);
        //与调用方传递过来的 token 进行匹配
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verfication failed.");
        }
    }
}
