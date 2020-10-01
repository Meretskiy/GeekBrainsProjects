package ru.meretskiy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.meretskiy.homework22_logAndTests.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayMassOneFourTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,3,4,5,6}, false},
                {new int[]{1,2,3,4,5}, false},
                {new int[]{1,1,4,4}, true},
                {new int[]{1,1,1,1,1,1}, false},
                {new int[]{4,4,4,4,4}, false},
        });
    }

    int[] array;
    boolean expected;

    public ArrayMassOneFourTest(int[] array, boolean expected) {
        this.array = array;
        this.expected = expected;
    }

    @Test
    public void testSplitArrayWithParams() {
        ArrayUtils arrayUtils = new ArrayUtils();
        Assert.assertEquals(expected, arrayUtils.isContainsOneAndFour(array));
    }


}
