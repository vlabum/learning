package ru.vlabum.se.hwthread;

/**
 * Класс вычисления функции y(x) = y(x)*sin(0.2+x/5)*cos(0.2+x/5)*cos(0.4+x/2)
 * Область определения - множество целых не отрицательных чсиел (Z U 0),
 *              т.к. выражение array[x] (он же y{x)) требует целого не отрицательного X
 * Область значений - множество вещественных чисел R
 */
public class FunctionComputation implements Runnable {

    private float[] array = null;       // множество результатов функции
    private int shift = 0;              // сдвиг по оси X

    FunctionComputation(float[] array, int shift) {
        this.array = array;
        this.shift = shift;
    }

    private void compute() {
        for (int x = 0; x < array.length; x++) {
            array[x] = (float)(array[x]
                    * Math.cos(0.2f + (x + shift) / 5)
                    * Math.sin(0.2f + (x + shift) / 5)
                    * Math.cos(0.4f + (x + shift) / 2));
        }
    }

    @Override
    public void run() {
        compute();
    }
}
