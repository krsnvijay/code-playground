package playground.ds;

import playground.ds.interfaces.LinkedListAPI;

import java.util.Arrays;

public class LinkedList implements LinkedListAPI {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    int length;


    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int valueAt(int index) {
        Node movePtr = head;
        for (int i = 0; i < index; i++) {
            movePtr = movePtr.next;
        }
        return movePtr.value;
    }

    @Override
    public void pushFront(int value) {
        Node node = new Node(value);
        if (length > 0) {
            node.next = head;
        }
        head = node;
        length++;
    }

    @Override
    public int popFront() {
        if (length == 0) {
            System.out.println("Error: List empty");
            return -1;
        }
        int frontValue = head.value;
        head = head.next;
        length--;
        return frontValue;
    }

    @Override
    public void pushBack(int value) {
        Node node = new Node(value);
        if (length < 1) {
            head = node;
        } else {
            // traverse till the end
            Node movePtr = head;
            while (movePtr.next != null) {
                movePtr = movePtr.next;
            }
            movePtr.next = node;
        }
        length++;
    }

    @Override
    public int popBack() {
        if (length == 0) {
            System.out.println("Error: List empty");
            return -1;
        }
        Node movePtr = head;
        Node prevPtr = head;
        while (movePtr.next != null) {
            prevPtr = movePtr;
            movePtr = movePtr.next;
        }
        int rearValue = movePtr.value;
        prevPtr.next = null;
        length--;
        return rearValue;

    }

    @Override
    public int getFront() {
        return head.value;
    }

    @Override
    public int getBack() {
        Node movePtr = head;
        while (movePtr.next != null) {
            movePtr = movePtr.next;
        }
        return movePtr.value;
    }

    @Override
    public void insertAt(int index, int value) {
        if (index >= length) {
            System.out.println("Error: Out Of Bounds");
        }
        Node movePtr = head;
        int i = 0;
        while (i < index - 1) {
            movePtr = movePtr.next;
            i++;
        }
        if (movePtr == head) {
            pushFront(value);
        } else {
            Node node = new Node(value);
            node.next = movePtr.next;
            movePtr.next = node;
            length++;

        }
    }

    @Override
    public int eraseAt(int index) {
        if (index >= length) {
            System.out.println("Error: Out Of Bounds");
        }
        Node movePtr = head;
        int i = 0;
        while (i < index - 1) {
            movePtr = movePtr.next;
            i++;
        }
        return removeNextNode(movePtr);

    }

    @Override
    public int getValueNFromEnd(int n) {
        int i = 0;
        Node movePtr = head;
        while (i < length - n) {
            movePtr = movePtr.next;
            i++;
        }
        return movePtr.value;
    }

    @Override
    public void reverse() {
        Node movePtr = head;
        Node prevPtr = null;
        while (movePtr.next != null) {
            Node prevNode = prevPtr;
            prevPtr = movePtr;
            movePtr = movePtr.next;
            prevPtr.next = prevNode;
        }
        movePtr.next = prevPtr;
        head = movePtr;
    }

    @Override
    public int removeValue(int value) {
        Node movePtr = head;
        int i = 0;
        while (movePtr.next != null && movePtr.next.value != value) {
            movePtr = movePtr.next;
            i++;
        }
        return removeNextNode(movePtr);
    }

    private int removeNextNode(Node movePtr) {
        int removedVal = -1;
        if (movePtr == head) {
            removedVal = popFront();
        } else {
            Node nextNode = movePtr.next;
            movePtr.next = nextNode.next;
            removedVal = nextNode.value;
            length--;

        }
        return removedVal;
    }

    @Override
    public int[] getValues() {
        Node movePtr = head;
        int[] values = new int[length];
        int i = 0;
        while (movePtr != null) {
            values[i++] = movePtr.value;
            movePtr = movePtr.next;
        }
        return values;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "values=" + Arrays.toString(getValues()) +
                ", length=" + length +
                '}';
    }
}
