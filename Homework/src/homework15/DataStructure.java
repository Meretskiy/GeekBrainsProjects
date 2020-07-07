package homework15;

public class DataStructure {

    public static void main(String[] args) {

        doTest();
    }

    public static void doTest() {

        DirectionalList directionalList = new DoublyDirectionalList();
        directionalList.addFirst("val1");
        directionalList.addFirst("val2");
        directionalList.addLast("val3");
        directionalList.addFirst("val4");
        directionalList.addFirst("val5");
        directionalList.addLast("val6");
        directionalList.addFirst("val7");
        directionalList.iterateForward();
        directionalList.iterateBackward();
        directionalList.size();
        directionalList.removeFirst();
        directionalList.removeLast();
        directionalList.size();
        directionalList.iterateForward();

        System.out.println("----------------");

        String[] strings = {"val10" , "val20", "val30", "val40", "val50"};

        DirectionalList directionalList1 = new DoublyDirectionalList(strings);
        directionalList1.iterateForward();
        directionalList1.size();

        DoublyDirectionalList.Node first = (DoublyDirectionalList.Node) directionalList1.getHead();
        System.out.println(first.getVal());
    }
}
