package DesignPattern.BehavioralPattern.IteratorPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/2
 * description:
 */
public interface Iterator<E> {
    boolean hasNext();

    void next();

    E currentItem();
}
