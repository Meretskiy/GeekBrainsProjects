package lesson7_dataStructure.lesson;

public class OneDirectionalList implements DirectionalList {
    private Node head;

    @Override
    public void add(String val) {
        if (head == null) {
            head = new Node(val, null);
            return;
        }

        add(val, head);
    }

    @Override
    public boolean remove(String val) {
        if (head.getVal().equals(val)) {
            if (head.getNext() == null) {
                head = null;
            } else {
                /**
                 * Будьте внимательные происходит замена ссылки
                 * first уже не будет прежним
                 */
                head = head.getNext();
            }
            return true;
        }

        Node tmp = head.getNext();
        Node prev = head;

        while (tmp != null) {
            if (tmp.getVal().equals(val)) {
                prev.setNext(tmp.getNext());
                return true;
            } else {
                prev = tmp;
                tmp = tmp.getNext();
            }
        }

        return false;
    }


    /**
     * Вариант с рекурсией
     */
//    @Override
//    public boolean remove(String val) {
//        if (first.getVal().equals(val)) {
//            if (first.getNext() == null) {
//                first = null;
//            } else {
//                first = first.getNext();
//            }
//            return true;
//        }
//        return remove(val, first, first.getNext());
//    }
//
//    private boolean remove(String val, Node prev, Node current) {
//        if (current == null) {
//            return false;
//        }
//
//        if (current.getVal().equals(val)) {
//            prev.setNext(current.getNext());
//            return true;
//        }
//
//        return remove(val, current, current.getNext());
//    }

    private void add(String val, Node current) {
        if (current.getNext() == null) {
            current.setNext(new Node(val, null));
        } else {
            add(val, current.getNext());
        }
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }

        int size = 1;

        Node current = head;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public class Node {
        private String val;
        private Node next;

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
