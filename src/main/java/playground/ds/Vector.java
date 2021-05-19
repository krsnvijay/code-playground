package playground.ds;

import playground.ds.interfaces.VectorInterface;

import java.util.Arrays;

public class Vector implements VectorInterface {
    int[] arr;
    int capacity;
    int length;
    final int MIN_CAPACITY = 16;

    public Vector() {
        this.capacity = MIN_CAPACITY;
        this.arr = new int[capacity];
        this.length = 0;
    }

    public Vector(int... arr) {
        int base = (int) (Math.log(arr.length) / Math.log(2));
        int nextBestCapacity = (int) Math.pow(2, base + 1);
        int maxCapacity = Math.max(MIN_CAPACITY, nextBestCapacity);
        this.length = arr.length;
        this.arr = arr;
        resize(maxCapacity);

    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int at(int index) {
        return arr[index];
    }

    @Override
    public void push(int element) {
        if (length > capacity) {
            resize(capacity * 2);
        }
        arr[length++] = element;
    }

    @Override
    public void insert(int index, int item) {
        if (length > capacity) {
            resize(capacity * 2);
        }
        for (int i = length; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public void prepend(int item) {
        insert(0, item);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: Vector empty");
            return -1;
        }
        int valueToDelete = arr[length - 1];
        arr[length - 1] = 0;
        length--;
        return valueToDelete;
    }

    @Override
    public int delete(int index) {
        if (isEmpty()) {
            System.out.println("Error: Vector empty");
            return -1;
        }
        int valueToDelete = arr[index];
        for (int i = index + 1; i < length; i++) {
            arr[i - 1] = arr[i];
        }
        pop();
        return valueToDelete;
    }

    @Override
    public int remove(int item) {
        if (isEmpty()) {
            System.out.println("Error: Vector empty");
            return -1;
        }

        int writePtr = 0;
        for (int readPtr = 0; readPtr < length; readPtr++) {
            if (arr[readPtr] != item) {
                arr[writePtr++] = arr[readPtr];
            }
        }
        return writePtr;
    }

    @Override
    public int find(int item) {
        for (int i = 0; i < length; i++) {
            if (item == arr[i])
                return i;
        }
        return -1;
    }

    @Override
    public void resize(int newCapacity) {
        int[] tempArr = new int[newCapacity];
        System.arraycopy(this.arr, 0, tempArr, 0, arr.length);
        this.arr = tempArr;
        this.capacity = newCapacity;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "arr=" + Arrays.toString(arr) +
                ", capacity=" + capacity +
                ", length=" + length +
                '}';
    }
}
