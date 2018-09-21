package ru.vlabum.se.hwcollections;

import java.util.HashMap;
import java.util.Map;

public class ExampleCollection {

    public static void main(String[] args) {

        String[] arrayWords = {
                "One", "Two", "Three", "City", "Week",
                "Sunday", "Two", "Three", "Three", "Value"
        };

        Map<String, Integer> numberOfWords = getNumberOfWords(arrayWords);

        // выводим список уникальных слов
        System.out.println("Список уникальных слов:");
        for (Map.Entry<String, Integer> m : numberOfWords.entrySet()) {
            if (m.getValue() == 1)
                System.out.println(m.getKey());
        }

        System.out.println();

        // выведем весь список слов
        System.out.println("Полный список слов, с количеством включений:");
        for (Map.Entry<String, Integer> m : numberOfWords.entrySet()){
            System.out.printf("%s - %d\n", m.getKey(), m.getValue());
        }
    }

    /**
     * Принимает в качестве аргумента массив и возвращает HashMap, с подсчитанным количеством слов
     * Все слова приводятся в нижний регистр.
     * @param   array - маассив слов
     * @return  объект HashMap, где ключем является слово в нижнем регистре,
     *          а значением - количество вхождений слова во входном массива
     */
    public static Map<String, Integer> getNumberOfWords(String[] array) {
        Map<String, Integer> map = new HashMap<String, Integer>(array.length);
        for (int i = 0; i < array.length; i++) {
            String word = array[i].toLowerCase();
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        return map;
    }

}
