package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static boolean checkStringCorrect(String checkString) {
        if (null == checkString || checkString.isEmpty() || ((checkString.length() % 2) != 0)) {
            return true;
        } else {
            char[] ch = checkString.toCharArray();
            for (char c : ch) {
                if (!(c == '(' || c == ')')) {
                    return true;
                }
            }
            return false;
        }
    }

    public static List<String> clusterize(String stringInput) {
        if (checkStringCorrect(stringInput)) {
            throw new IllegalArgumentException("Введена некорректная строка!");
        }
        List<String> clusterizeString = new ArrayList<>();
        Integer notClosedBracket = 0;
        int startIndexCluster = 0;
        for (int i = 0; i < stringInput.length(); i++) {
            if (stringInput.charAt(i) == '(') {
                notClosedBracket = notClosedBracket + 1;
            } else {
                notClosedBracket = notClosedBracket - 1;
            }
            if (notClosedBracket.equals(0)) {
                clusterizeString.add(stringInput.substring(startIndexCluster, i + 1));
                startIndexCluster = i + 1;
            }
        }
        if (!notClosedBracket.equals(0)) {
            throw new IllegalArgumentException("Не у всех скобок есть пара");
        }
        return clusterizeString;
    }
}
