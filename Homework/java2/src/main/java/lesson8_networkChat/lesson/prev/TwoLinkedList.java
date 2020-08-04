package lesson8_networkChat.lesson.prev;

public class TwoLinkedList {
    private Node first;

    public void add(String val) {
        if (first == null) {
            first = new Node(val);
            return;
        }

        add(val, first, first);
    }

    public void add(String val, int index) {
        // TODO Вставка по индексу
    }

    private void add(String val, Node prev, Node current) {
        // 1. V: a, Prev: null, Next: 2
        // 2. V: ab, Prev: 1, Next: 3
        // 3. V: abx, Prev: 2, Next: null
        // ...
        // N ...

        if (current.getNext() == null) {
            current.setNext(new Node(val, prev));
        } else {
            add(val, current, current.getNext());
        }
    }

    public static class Node {
        private String val;
        private Node prev;
        private Node next;

        public Node(String val) {
            this(val, null);
        }

        public Node(String val, Node prev) {
            this(val, prev, null);
        }

        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
