package playground.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.*;


class VectorTest {
    Vector vector;
    int[] values = {1, 2, 3, 2, 5};

    @BeforeEach
    void setUp() {
        vector = new Vector(values);
    }

    @Test
    void size() {
        assertEquals(values.length, vector.size());
    }

    @Test
    void capacity() {
        assertEquals(16, vector.capacity());
    }

    @Test
    void isEmpty() {
        Vector emptyVector = new Vector();
        assertTrue(emptyVector.isEmpty());
        assertFalse(vector.isEmpty());
    }

    @Test
    void at() {
        assertEquals(values[2], vector.at(2));
    }

    @Test
    void push() {
        int element = 6;
        vector.push(element);
        assertEquals(element, vector.at(vector.length - 1));

        int currentLength = vector.size();
        for (int i = 0; i < 20; i++) {
            vector.push(i);
        }
        System.out.println(vector);
        assertEquals(currentLength + 20, vector.size());

    }

    @Test
    void insert() {
        int element = 2;
        int idx = 2;
        vector.insert(idx, element);
        assertEquals(element, vector.at(idx));
    }

    @Test
    void prepend() {
        int element = 9;
        vector.prepend(element);
        assertEquals(element, vector.at(0));
    }

    @Test
    void pop() {
        int lastElement = values[values.length - 1];
        assertEquals(lastElement, vector.pop());
    }

    @Test
    void delete() {
        int idxToDelete = 3;
        System.out.println(vector);
        int deletedElement = vector.delete(idxToDelete);
        int expectedElement = values[idxToDelete + 1];
        System.out.println(vector);
        assertEquals(expectedElement, vector.at(idxToDelete));
    }

    @Test
    void remove() {
        int elementToDelete = 2;
        System.out.println(vector);
        vector.remove(elementToDelete);
        System.out.println(vector);
        List<Integer> vectorList = IntStream.of(vector.arr).boxed().collect(Collectors.toList());
        assertThat(vectorList, not(hasItem(elementToDelete)));
    }

    @Test
    void find() {
        int idxToFind = 2;
        int elementToFind = values[2];
        int idx = vector.find(elementToFind);
        assertEquals(idxToFind, idx);

        elementToFind = 99;
        idx = vector.find(elementToFind);
        assertEquals(-1, idx);
    }

    @Test
    void resize() {
        int newCapacity = 21;
        vector.resize(newCapacity);
        System.out.println(vector);
        assertEquals(newCapacity, vector.capacity());
    }
}