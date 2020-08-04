package ru.meretskiy.homework15_dataStructure;

public class DoublyDirectionalList implements DirectionalList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyDirectionalList() {
        size = 0;
    }

    public DoublyDirectionalList(String[] strings) {
        size = 0;

        for (int i = 0; i < strings.length; i++) {
            this.addLast(strings[i]);
        }
    }

    public class Node {

        private String val;
        private Node next;
        private Node prev;

        public Node(String val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public String getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }
    }

    @Override
    public void addFirst(String val) {

        Node tmp = new Node(val, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("Adding element: " + val);
    }

    @Override
    public void addLast(String val) {

        Node tmp = new Node(val, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("Adding element: " + val);
    }

    @Override
    public void iterateForward() {
        System.out.println("Iterate forward:");
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    @Override
    public void iterateBackward() {
        System.out.println("Iterate backward:");
        Node tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.prev;
        }
    }

    @Override
    public String removeFirst() {
        if (size != 0) {
            Node tmp = head;
            head = head.next;
            head.prev = null;
            size--;
            System.out.println("Deleted: " + tmp.val);
            return tmp.val;
        }
        return "Error, is empty!";
    }

    @Override
    public String removeLast() {
        if (size != 0) {
            Node tmp = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
            System.out.println("Deleted: " + tmp.val);
            return tmp.val;
        }
        return "Error, is empty!";
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Node getHead() {
        return head;
    }
}
