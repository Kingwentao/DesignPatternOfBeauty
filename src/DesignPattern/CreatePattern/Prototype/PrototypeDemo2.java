package DesignPattern.CreatePattern.Prototype;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/2/25
 * description: 原型设计模式 （示例使用深拷贝）
 */
public class PrototypeDemo2 {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {

        //使用深拷贝实现一份新数据。
        //方法1：递归拷贝对象、对象的引用对象以及引用对象的引用对象……直到要拷贝的对象只包含基本数据类型数据，没有引用对象为止。
        HashMap<String, SearchWord> newKeywords = new HashMap<>();
        for (HashMap.Entry<String, SearchWord> e : currentKeywords.entrySet()) {
            SearchWord searchWord = e.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyword(), searchWord.getCount(),
                    searchWord.getLastUpdateTime());
            newKeywords.put(e.getKey(), newSearchWord);
        }

        //方法2：先将对象序列化，然后再反序列化成新的对象。
        for (HashMap.Entry<String, SearchWord> e : currentKeywords.entrySet()) {
            SearchWord searchWord = e.getValue();
            try {
                SearchWord newSearchWord = (SearchWord) deepCopy(searchWord);
                newKeywords.put(e.getKey(),newSearchWord);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

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

    //先将对象序列化，然后再反序列化成新的对象。
    public Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
