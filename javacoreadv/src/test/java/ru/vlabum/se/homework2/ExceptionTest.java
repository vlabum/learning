package ru.vlabum.se.homework2;

import org.junit.Assert;
import org.junit.Test;

import static ru.vlabum.se.homework2.TestException.sumTextArray;

public class ExceptionTest {

    @Test(expected = MyArraySizeException.class)
    public void testWrongLength() throws MyException{
        String[][] arr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(i + j);
            }
        }
        sumTextArray(arr);
    }

    @Test(expected = MyArrayDataException.class)
    public void testWrongData() throws MyException{
        String[][] arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(i + j);
            }
        }
        arr[1][1] = "asdf";
        sumTextArray(arr);
    }

    @Test
    public void testSum() throws MyException{
        String[][] arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(i + j);
            }
        }
        Assert.assertTrue(sumTextArray(arr) == 48);
    }
}
