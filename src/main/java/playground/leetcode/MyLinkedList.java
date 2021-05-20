package playground.leetcode;

import java.util.Arrays;

public class MyLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    Node head;
    int length;

    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= length || index < 0)
            return -1;
        Node movePtr = head;
        for (int i = 0; i < index; i++) {
            movePtr = movePtr.next;
        }
        return movePtr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node movePtr = head;
        while (movePtr.next != null) {
            movePtr = movePtr.next;
        }
        movePtr.next = newNode;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == length) {
            addAtTail(val);
            return;
        }
        if (index > length) {
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node movePtr = head;
        for (int i = 0; movePtr != null && i < index - 1; i++) {
            movePtr = movePtr.next;
        }
        if (movePtr == null)
            return;
        newNode.next = movePtr.next;
        movePtr.next = newNode;
        length++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > length || head == null || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node movePtr = head;
        for (int i = 0; movePtr != null && i < index - 1; i++) {
            movePtr = movePtr.next;
        }
        if (movePtr == null || movePtr.next == null)
            return;

        Node curPtr = movePtr.next;
        movePtr.next = curPtr.next;
        length--;
    }

    @Override
    public String toString() {
        int[] values = new int[length];
        if (head != null) {
            Node movePtr = head;
            for (int i = 0; i < length; i++) {
                values[i] = movePtr.val;
                movePtr = movePtr.next;
            }
        }
        return "MyLinkedList{length=" + length +
                ",values=" + Arrays.toString(values) + "}";
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0,10);
        myLinkedList.addAtIndex(0,20);
        myLinkedList.addAtIndex(1,30);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));
    }
}

