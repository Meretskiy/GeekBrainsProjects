package book.shildt.solution13_1;

public interface IGenQ<T> {

    void put(T ch) throws QueueFullException;

    T get() throws QueueEmptyException;
}
