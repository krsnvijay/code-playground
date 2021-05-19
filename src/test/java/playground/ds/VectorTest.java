package playground.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int deletedElement = vector.delete(idxToDelete);
        int expectedElement = values[idxToDelete + 1];
        assertEquals(expectedElement, vector.at(idxToDelete));
    }

    @Test
    void remove() {
        int elementToDelete = 2;
        vector.remove(elementToDelete);
    }

    @Test
    void find() {
    }

    @Test
    void resize() {
    }
}