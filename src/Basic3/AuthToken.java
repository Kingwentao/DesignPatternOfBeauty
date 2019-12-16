package Basic3;

/**
 * author: WentaoKing
 * created on: 2019/12/5
 * description:
 */
class AuthToken {

    private String token;
    private Long timeStamp;

    AuthToken(String token,Long  timestamp){
        this.token = token;
        this.timeStamp = timestamp;
    }

    //对字符串通过加密算法加密生成 token
    public static AuthToken generate(String originalUrl, String appId, String password, long timestamp) {
        return null;
    }


    public boolean match(AuthToken clientAuthToken) {
        return false;
    }

    public boolean isExpired() {
        return false;
    }
}
