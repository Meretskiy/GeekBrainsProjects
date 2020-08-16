package ru.meretskiy.task1;

import org.junit.*;
import ru.meretskiy.task1.tests.Calculator;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void init() {
        System.out.println("init");
        calculator = new Calculator();
    }

    @AfterClass
    public static void close() {
        System.out.println("Calculator close");
    }

    /*@Before
    public void init() {
        System.out.println("init");
        this.calculator = new Calculator();
    }

    @After
    public void close() {
        System.out.println("Calculator close");
    }*/

    @Test
    public void addSuccessTest() {
        Assert.assertEquals(4, calculator.add(2 ,2 ));
    }

    @Test
    public void multiplySuccessTest() {
        Assert.assertEquals(6, calculator.multiply(2 ,3 ));
    }

    @Test
    public void divSuccessTest() {
        Assert.assertEquals(2, calculator.div(6 ,3 ));
    }

    @Test(expected = ArithmeticException.class)
    public void divByZeroTest() {
        calculator.div(6, 0);
    }

    @Test(timeout = 300L)
    public void addTimeoutSuccessTest() {
        calculator.add(2, 2);
    }

    @Test(timeout = 100L)
    @Ignore
    public void addTimeoutNegativeTest() {
        calculator.add(2, 2);
    }
}
