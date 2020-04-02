package DesignPattern.BehavioralPattern.IteratorPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/2
 * description:
 */
public class ArrayList<E> implements List<E> {

    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public int size() {
        //...
        return 0;
    }

    @Override
    public void add(E element) {
        //...
    }

    @Override
    public E get(int index) {
        //...
        return null;
    }
}
