package ru.meretskiy;

import org.junit.Test;
import ru.meretskiy.homework22_logAndTests.ArrayUtils;

public class ArrayUtilsException {

    @Test(expected = RuntimeException.class)
    public void testArraySplitException() {
        int[] array = new int[]{1,1,2};
        int splitValue = 4;
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.splitArray(array, splitValue);
    }
 }
