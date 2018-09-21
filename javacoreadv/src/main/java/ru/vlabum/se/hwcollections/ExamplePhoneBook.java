package ru.vlabum.se.hwcollections;

public class ExamplePhoneBook {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.add("+79991111111", "Иванов");
        book.add("+79992222222", "Петров");
        book.add("+79993333333", "Петров");
        book.add("+79994444444", "Сидоров");

        System.out.println(book.get("Петров"));
    }
}
