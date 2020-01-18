package HW11;

public interface MyList<E> extends Iterable<Object> {
    void add(E e);
    void clear();
    boolean remove(Object o);
    Object[] toArray();
    int size();
    boolean contains(E o);
    boolean containsAll(MyList c);
    Object get(int index);
}
