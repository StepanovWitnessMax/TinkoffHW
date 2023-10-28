package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {
    }

    public static void checkList(List<?> listInput) {
        if ((listInput == null) || listInput.isEmpty()) {
            throw new IllegalArgumentException("Введен некорректный список");
        }
    }

    public static Map<?, Integer> freqDict(List<?> listInput) {
        checkList(listInput);
        Map<Object, Integer> dictionary = new HashMap<>();
        for (Object key : listInput) {
            if (dictionary.containsKey(key)) {
                dictionary.put(key, dictionary.get(key) + 1);
            } else {
                dictionary.put(key, 1);
            }
        }
        return dictionary;
    }
}
