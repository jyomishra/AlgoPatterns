package com.test.algo.linked_list;

public class LinkedList {

    private Node head;

    public Node append(int data) {
        Node next = new Node(data);
        if (head == null) {
            head = next;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = next;
        }
        return head;
    }

    public Node appendNode(Node next) {
        if (head == null) {
            head = next;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = next;
        }
        return head;
    }

    public Node addInFront(int data) {
        Node next = new Node(data);
        if (head != null) {
            next.next = head;
        }
        head = next;
        return head;
    }

    public Node addAt(int data, int pos) {
        Node node = new Node(data);
        int i = 0;
        if (pos == 0) {
            addInFront(data);
        }
        Node prev = null;
        Node current = head;
        while (current != null && i != pos) {
            prev = current;
            current = current.next;
            i++;
        }
        prev.next = node;
        node.next = current;
        return head;
    }

    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int data) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addInFront(3);
        ll.addInFront(7);
        ll.addInFront(6);
        ll.addAt(4, 1);
        ll.delete(7);
        ll.print();
    }
}