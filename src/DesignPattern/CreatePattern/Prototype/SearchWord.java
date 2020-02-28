package DesignPattern.CreatePattern.Prototype;

/**
 * author: WentaoKing
 * created on: 2020/2/25
 * description:
 */
public class SearchWord {


    int count;
    long lastUpdateTime;
    String keyWord;

    public SearchWord(String keyWord, int count, long lastUpdateTime) {
        this.count = count;
        this.lastUpdateTime = lastUpdateTime;
        this.keyWord = keyWord;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyword() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
