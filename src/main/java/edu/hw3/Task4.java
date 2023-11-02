package edu.hw3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Task4 {

    private Task4() {
    }

    @SuppressWarnings("MagicNumber")
    private static final LinkedHashMap<String, Integer> CONVERT_DICTIONARY = new LinkedHashMap<>() {
        {
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);

        }
    };

    private static final Integer MAX_CONVERT_NUMBER = 3999;
    private static final Integer MIN_CONVERT_NUMBER = 1;

    public static void checkNumber(Integer number) {
        if ((number == null) || (number < MIN_CONVERT_NUMBER) || (number > MAX_CONVERT_NUMBER)) {
            throw new IllegalArgumentException("Введено некорректное число!");
        }
    }

    public static String convertToRoman(Integer arabNumber) {
        checkNumber(arabNumber);
        Integer processedNumber = arabNumber;
        List<String> convertList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : CONVERT_DICTIONARY.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            while (processedNumber >= val) {
                convertList.add(key);
                processedNumber = processedNumber - val;
            }
        }
        return String.join("", convertList);
    }
}
