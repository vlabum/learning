package ru.vlabum.se.homework2;

public class MyArraySizeException extends MyException {

    private int lenArray;

    public MyArraySizeException(int lenArray) {
        this.lenArray = lenArray;
    }

    @Override
    public String getErrorText() {
        return "Размерность не равна " + lenArray;
    }
}
