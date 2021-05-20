package playground.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
        for (int i = 65; i < 75; i++) {
            stack.push((char) i);

        }
    }

    @Test
    void push() {
        System.out.println(stack);
        stack.push('a');
        System.out.println(stack);
        assertEquals('a', stack.peek());
    }

    @Test
    void pop() {
        System.out.println(stack);
        int topVal = stack.peek();
        assertEquals(topVal, stack.pop());
    }
}