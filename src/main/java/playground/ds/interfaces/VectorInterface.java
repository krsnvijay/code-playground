package playground.ds.interfaces;

public interface VectorInterface {
    int size();

    int capacity();

    boolean isEmpty();

    int at(int index);

    void push(int element);

    void insert(int index, int item);

    void prepend(int item);

    int pop();

    int delete(int index);

    int remove(int item);

    int find(int item);

    void resize(int newCapacity);
}
