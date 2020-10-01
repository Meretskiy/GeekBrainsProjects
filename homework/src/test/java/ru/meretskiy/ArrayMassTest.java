package ru.meretskiy;

import org.junit.*;
import ru.meretskiy.homework22_logAndTests.ArrayUtils;

public class ArrayMassTest {

    private static ArrayUtils arrayUtils = new ArrayUtils();

    @Test
    public void splitArrayTest() {
        Assert.assertArrayEquals(new int[]{2, 3, 8}, arrayUtils.splitArray(new int[]{4, 5, 4, 2, 3, 8}, 4));
        Assert.assertArrayEquals(new int[]{1, 7}, arrayUtils.splitArray(new int[]{9, 5, 0, 4, 1, 7}, 4));
        Assert.assertArrayEquals(new int[]{5, 7, 2, 3, 8}, arrayUtils.splitArray(new int[]{4, 5, 7, 2, 3, 8}, 4));
    }

    @Test
    public void isContainsOneAndFourTest() {
        Assert.assertTrue(arrayUtils.isContainsOneAndFour(new int[]{1,1,1,1,4,1,1,1}));
        Assert.assertTrue(arrayUtils.isContainsOneAndFour(new int[]{4,4,1,1,1,1,4,4}));
        Assert.assertTrue(arrayUtils.isContainsOneAndFour(new int[]{4,1,4,1,4,4,4,1}));
    }
}
