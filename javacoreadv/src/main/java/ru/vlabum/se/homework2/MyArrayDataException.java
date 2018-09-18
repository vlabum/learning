package ru.vlabum.se.homework2;

public class MyArrayDataException extends MyException {

    private int row;
    private int col;

    public MyArrayDataException(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String getErrorText() {
        return "В ячейке [" + row + "][" + col + "] указано не число";
    }
}
