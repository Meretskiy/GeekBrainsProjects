package ru.meretskiy;

import org.junit.*;
import ru.meretskiy.homework22_logAndTests.MainClass;

public class MainClassTest {

    private static MainClass mainClass = new MainClass();

    @Test
    public void splitArrayTest() {
        Assert.assertArrayEquals(new int[]{2, 3, 8}, mainClass.splitArray(new int[]{4, 5, 4, 2, 3, 8}, 4));
        Assert.assertArrayEquals(new int[]{1, 7}, mainClass.splitArray(new int[]{9, 5, 0, 4, 1, 7}, 4));
        Assert.assertArrayEquals(new int[]{5, 7, 2, 3, 8}, mainClass.splitArray(new int[]{4, 5, 7, 2, 3, 8}, 4));
    }

//    @Test
//    public void isContainsOneOrFourTest() {
//        Assert.assertTrue(mainClass.isContainsOneOrFour(new int[]{1, 3, 5, 7}, 1, 4));
//        Assert.assertTrue(mainClass.isContainsOneOrFour(new int[]{11, 3, 5, 7, 12, 4}, 1, 4));
//        Assert.assertTrue(mainClass.isContainsOneOrFour(new int[]{5, 7, 9, 3, 1, 7, 4, 1}, 1, 4));
//    }

    @Test
    public void isContainsOneAndFourTest() {
        Assert.assertTrue(mainClass.isContainsOneAndFour(new int[]{1,1,1,1,4,1,1,1}));
        Assert.assertTrue(mainClass.isContainsOneAndFour(new int[]{4,4,1,1,1,1,4,4}));
        Assert.assertTrue(mainClass.isContainsOneAndFour(new int[]{4,1,4,1,4,4,4,1}));
    }
}
