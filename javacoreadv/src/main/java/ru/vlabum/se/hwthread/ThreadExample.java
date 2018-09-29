package ru.vlabum.se.hwthread;

public class ThreadExample {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        final float[] array = new float[size];

        initArray(array, 1.0f);
        method1(array); // расчет в одном потоке

        initArray(array, 1.0f);
        method2(array); // расчет в 2 потока
    }

    /**
     * Вычисляет значения массива одним потоком
     * @param array - массив значений
     */
    static void method1(float[] array) {
        long a = System.currentTimeMillis();
        final FunctionComputation fc = new FunctionComputation(array, 0);
        fc.run();
        System.out.println(System.currentTimeMillis() - a);
    }

    /**
     * Вычисляет значения массива двумя потоками
     * @param array
     * @throws InterruptedException
     */
    static void method2(float[] array) throws InterruptedException {
        long a = System.currentTimeMillis();
        final float[] arr1 = new float[h];
        final float[] arr2 = new float[h];

        System.arraycopy(array, 0, arr1, 0, h);
        System.arraycopy(array, h, arr2, 0, h);

        final FunctionComputation fc1 = new FunctionComputation(arr1, 0);
        final FunctionComputation fc2 = new FunctionComputation(arr2, h);
        final Thread thread1 = new Thread(fc1);
        final Thread thread2 = new Thread(fc2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, array, 0, h);
        System.arraycopy(arr2, 0, array, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }

    /**
     * Инициализация массива определенным значением
     * @param array - массив
     * @param initValue - значение, которым будут определены элементы массива
     */
    static void initArray(float[] array, float initValue) {
        for (int i = 0; i < array.length; i++) {
            array[i] = initValue;
        }
    }

}
