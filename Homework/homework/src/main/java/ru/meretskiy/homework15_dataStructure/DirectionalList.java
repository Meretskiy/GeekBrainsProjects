package ru.meretskiy.homework15_dataStructure;

public interface DirectionalList {

    void addFirst(String val);
    void addLast(String val);
    void iterateForward();
    void iterateBackward();
    String removeFirst();
    String removeLast();
    int size();
    Object getHead();
    boolean isEmpty();
}
