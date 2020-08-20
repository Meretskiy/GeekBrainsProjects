import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) {

       TestRunner testRunner = new TestRunner();
        try {
            testRunner.start(TestExample.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
