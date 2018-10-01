package ru.vlabum.se.hwthread;

import org.junit.Assert;
import org.junit.Test;

public class ThreadTest {

    @Test
    public void compareValuesCopyArr() throws InterruptedException {
        final float[] arr1 = new float[ThreadExample.size];
        ThreadExample.initArray(arr1, 1.0f);
        final float[] arr2 = new float[ThreadExample.size];
        ThreadExample.initArray(arr2, 1.0f);
        ThreadExample.method1(arr1);
        ThreadExample.method2(arr2);
        Assert.assertArrayEquals(arr2, arr1, 0.0f);
    }
}
