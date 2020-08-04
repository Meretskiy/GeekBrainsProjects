package book.shildt;

public class Gen<T> {

    private T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    public void showType() {
        System.out.println("Type T - this " + ob.getClass().getName());
    }
}
