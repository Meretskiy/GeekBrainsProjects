package book.shildt.solution13_1;

public class QueueFullException extends Exception {

    int size;

    QueueFullException(int size) {
        this.size = size;
    }

    public String toString() {
        return "\nQueue is full, maximum size: " + size;
    }
}
