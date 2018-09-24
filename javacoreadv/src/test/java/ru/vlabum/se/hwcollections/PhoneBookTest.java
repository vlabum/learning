package ru.vlabum.se.hwcollections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTest {

    private int maxNumber = 100000;

    @Test
    public final void useHashMap() {
        final PhoneBook phoneBook = new PhoneBook(false);
        String name;
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            name = "Name " + i;
            String number;
            for (int j = 0; j < maxNumber; j++) {
                number = String.valueOf((i * maxNumber) + j);
                phoneBook.add(number, name);
            }
        }
        System.out.printf("HashMap Заполнение %d\n", System.nanoTime() - start);
        name = "Name 10";
        start = System.nanoTime();
        final List<String> list = phoneBook.get(name);
        System.out.printf("HashMap Поиск полным перебором %d\n", System.nanoTime() - start);
    }


    @Test
    public final void useLinkedHashMap() {
        final PhoneBook phoneBook = new PhoneBook(true);
        String name;
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            name = "Name " + i;
            String number;
            for (int j = 0; j < maxNumber; j++) {
                number = String.valueOf((i * maxNumber) + j);
                phoneBook.add(number, name);
            }
        }
        System.out.printf("LinkedHashMap Заполнение %d\n", System.nanoTime() - start);
        name = "Name 10";
        start = System.nanoTime();
        final List<String> list = phoneBook.get(name);
        System.out.printf("LinkedHashMap Поиск полным перебором %d\n", System.nanoTime() - start);
    }

    /**
     * Тест для PhoneBook, в котором используется LinkedHashMap
     */
    @Test
    public final void getTest() {
        final PhoneBook book = new PhoneBook();

        book.add("+79991111111", "Иванов");
        book.add("+79992222222", "Петров");
        book.add("+79993333333", "Петров");
        book.add("+79994444444", "Сидоров");

        final List<String> list = new ArrayList<>();
        list.add("+79992222222");
        list.add("+79993333333");
        Assert.assertEquals(list,book.get("Петров"));
    }

}
