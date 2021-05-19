package playground.ds.interfaces;

public interface LinkedListAPI {
    int size();

    boolean isEmpty();

    int valueAt(int index);

    void pushFront(int value);

    int popFront();

    void pushBack(int value);

    int popBack();

    int getFront();

    int getBack();

    void insertAt(int index, int value);

    int eraseAt(int index);

    int getValueNFromEnd(int n);

    void reverse();

    int removeValue(int value);

    int[] getValues();
}
