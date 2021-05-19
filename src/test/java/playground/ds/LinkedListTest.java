package playground.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList linkedList;
    int LIST_SIZE = 10;
    int[] values = IntStream.range(0, LIST_SIZE).toArray();

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
        for (int value : values) {
            linkedList.pushBack(value);
        }
    }

    @Test
    void size() {
        assertEquals(LIST_SIZE, linkedList.size());
        System.out.println(linkedList);
    }

    @Test
    void isEmpty() {
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void valueAt() {
        int idxToCheck = 5;
        System.out.println(linkedList);
        assertEquals(values[idxToCheck], linkedList.valueAt(idxToCheck));
    }

    @Test
    void pushFront() {
        int newValue = 42;
        linkedList.pushFront(newValue);
        assertEquals(newValue, linkedList.valueAt(0));
    }

    @Test
    void popFront() {
        int expectedVal = values[0];
        int removedVal = linkedList.popFront();
        assertEquals(expectedVal, removedVal);
    }

    @Test
    void pushBack() {
        int newValue = 42;
        linkedList.pushBack(newValue);
        assertEquals(newValue, linkedList.valueAt(linkedList.length - 1));
    }

    @Test
    void popBack() {
        System.out.println(linkedList);
        int expectedVal = values[values.length - 1];
        int removedVal = linkedList.popBack();
        System.out.println(linkedList);
        assertEquals(expectedVal, removedVal);
    }

    @Test
    void getFront() {
        int expectedVal = values[0];
        int frontVal = linkedList.getFront();
        assertEquals(expectedVal, frontVal);
    }

    @Test
    void getBack() {
        int expectedVal = values[values.length - 1];
        int backVal = linkedList.getBack();
        assertEquals(expectedVal, backVal);
    }

    @Test
    void insertAt() {
        int idxToInsert = 5;
        int valueToInsert = 42;
        linkedList.insertAt(idxToInsert, valueToInsert);
        System.out.println(linkedList);
        assertEquals(valueToInsert, linkedList.valueAt(idxToInsert));

        int idxToInsert0 = 0;
        linkedList.insertAt(idxToInsert0, valueToInsert);
        System.out.println(linkedList);
        assertEquals(valueToInsert, linkedList.valueAt(idxToInsert0));
    }

    @Test
    void eraseAt() {
        int idxToErase = 5;
        int erasedVal = linkedList.eraseAt(idxToErase);
        System.out.println(linkedList);
        assertEquals(idxToErase, erasedVal);

        int idxToErase0 = 0;
        int erasedVal0 = linkedList.eraseAt(idxToErase0);
        System.out.println(linkedList);
        assertEquals(idxToErase0, erasedVal0);
    }

    @Test
    void getValueNFromEnd() {
        int n = 2;
        int expectedValue = values[values.length - 2];
        int actualValue = linkedList.getValueNFromEnd(n);
        System.out.println(linkedList);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void reverse() {
        // snip snap test
        linkedList.reverse();
        System.out.println(linkedList);
        linkedList.reverse();
        assertArrayEquals(values, linkedList.getValues());
    }

    @Test
    void removeValue() {
        int valueToRemove = 5;
        int erasedVal = linkedList.removeValue(valueToRemove);
        System.out.println(linkedList);
        assertEquals(valueToRemove, erasedVal);
    }
}