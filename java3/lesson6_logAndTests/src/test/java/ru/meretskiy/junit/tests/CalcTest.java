package ru.meretskiy.junit.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ru.meretskiy.junit.test.Calculator;

public class CalcTest {

    private static Calculator calculator;

    //инициализация данных для подготовки к тестам
    @BeforeClass
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(4, calculator.sub(6, 2));
    }

    @Test
    //игнорирует тест при прогоне всех тестов
    @Ignore
    public void testIntDiv() {
        //сравниваем эталонное число с результатом выполнения метода
        Assert.assertEquals(4, calculator.intDiv(8, 2));
    }

    //ожидаем что в результате теста выпадет ошибка
    @Test(expected = ArithmeticException.class)
    public void testIntDivBY0() {
        calculator.intDiv(10,0);
    }

    //если метод выполняется дольше заданного времени, он считается проваленным.
    @Test(timeout = 200L)
    public void timeoutTest() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
