import java.lang.reflect.InvocationTargetException;

public class TestExample {

    @BeforeSuite
    public static void firstTest() {
        System.out.println("First method");
    }

    @Test(priority = 8)
    public static void doTestOne() {
        System.out.println("One test completed...");
    }

    @Test(priority = 4)
    public static void doTestTwo() {
        System.out.println("Two test completed...");
    }

    @Test(priority = 2)
    public static void doTestThree() {
        System.out.println("Three test completed...");
    }

    @Test(priority = 5)
    public static void doTestFour() {
        System.out.println("Four test completed...");
    }

    @Test(priority = 1)
    public static void doTestFive() {
        System.out.println("Five test completed...");
    }

    @AfterSuite
    public static void lastTest() {
        System.out.println("Last method");
    }
}
