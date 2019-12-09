package Basic3;

/**
 * author: WentaoKing
 * created on: 2019/12/5
 * description:
 */
class ApiRequest {

        private String url;
        private String appId;
        private String token;
        private Long timeStamp;

    public String getAppId() {
        return appId;
    }

    public String getToken() {
        return token;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * @param url
     * @return
     */
    static ApiRequest buildFromUrl(String url) {

        return null;
    }


    public long getTimestamp() {
        return timeStamp;
    }

    public String getOriginalUrl() {
        return url;
    }
}
