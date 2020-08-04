package lesson7_dataStructure.hw;

public interface DirectionalList {

    void addFirst(String val);
    void addLast(String val);
    void iterateForward();
    void iterateBackward();
    String removeFirst();
    String removeLast();
    int size();
    boolean isEmpty();
    Object getHead();
}
