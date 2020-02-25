package DesignPattern.CreatePattern.Prototype;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: WentaoKing
 * created on: 2020/2/25
 * description: 原型设计模式
 */
public class PrototypeDemo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {

        //要先保留一份之前的数据，避免因为不同步导致的之前数据既不完全是最新的也不是旧的那一份
        // HashMap<String, SearchWord> newKeywords = new LinkedHashMap<>();

        //原型模式就这么简单，拷贝已有对象的数据，更新少量差值
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();


        long maxNewUpdatedTime = lastUpdateTime;
        // 从数据库中取出所有的数据，放入到newKeywords中 (问题：如果数据量非常大，这个拷贝的过程显然是比较耗时。为了提高效率，原型模式就派上用场了)
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }

            newKeywords.put(searchWord.getKeyword(), searchWord);
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords() {
        //从数据库中取出所有的数据
        return null;
    }
}
