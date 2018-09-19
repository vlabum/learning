package ru.vlabum.se.homework2;

public class TestException {

    public static final int lenArray = 4;

    public static void main(String[] args) {

        String[][] arr = new String[lenArray][lenArray];
        for (int i = 0; i < lenArray; i++) {
            for (int j = 0; j < lenArray; j++) {
                arr[i][j] = String.valueOf(i + j);
            }
        }

        System.out.println("Все числа");
        try {
            System.out.println(sumTextArray(arr));
        }
        catch (MyException e) {
            System.out.println(e.getErrorText());
        }

        System.out.println("Одну ячейку заменим на текст asdf");
        arr[0][0] = "asdf";


        try {
            System.out.println(sumTextArray(arr));
        }
        catch (MyException e) {
            System.out.println(e.getErrorText());
        }

        System.out.println("Пустой массив 2х2");
        try {
            System.out.println(sumTextArray(new String[2][2]));
        }
        catch (MyException e) {
            System.out.println(e.getErrorText());
        }

    }

    public static int sumTextArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (arr.length != lenArray)
            throw new MyArraySizeException(lenArray);

        for (int i = 0; i < lenArray; i++) {
            if (arr[i].length != lenArray)
                throw new MyArraySizeException(lenArray);
            for (int j = 0; j < lenArray; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

}
