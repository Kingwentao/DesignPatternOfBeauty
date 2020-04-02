package DesignPattern.BehavioralPattern.IteratorPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/2
 * description:
 */
public interface List<E> {
    Iterator iterator();

    int size();

    void add(E element);

    E get(int index);
}
