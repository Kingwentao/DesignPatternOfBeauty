package DesignPattern.BehavioralPattern.IteratorPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/2
 * description: 迭代器模式
 * 1。迭代器中需要定义 hasNext()、currentItem()、next() 三个最基本的方法。
 * 2。遍历的容器对象通过依赖注入传递到迭代器类中。
 * 3。容器通过 iterator() 方法来创建迭代器。
 */
public class IteratorPatternMain {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("abc");
        names.add("def");
        names.add("hig");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
