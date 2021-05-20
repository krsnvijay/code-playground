package playground.ds;

import playground.ds.interfaces.StackAPI;

import java.util.ArrayList;

public class Stack implements StackAPI {
    static class Node {
        Node next;
        char value;

        public Node(char value) {
            this.value = value;
        }
    }

    Node top;

    @Override
    public void push(char element) {
        Node newNode = new Node(element);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    @Override
    public char pop() {
        if (top == null) {
            return '\0';
        }
        char poppedValue = top.value;
        top = top.next;
        return poppedValue;
    }

    @Override
    public char peek() {
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        Node movePtr = top;
        ArrayList<Character> allValues = new ArrayList<>();
        while (movePtr != null) {
            allValues.add(movePtr.value);
            movePtr = movePtr.next;
        }
        return "Stack{" +
                "values=" + allValues +
                ",size=" + allValues.size() +
                '}';
    }
}
