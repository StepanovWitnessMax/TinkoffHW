package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Task6 {

    private Task6() {
    }

    private static final Integer[] UNCORRECT = {1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999};
    private static final int UPBORDER = 9999;
    private static final int DOWNBORDER = 1000;
    private static final int TEN = 10;
    private static final int KAPREKAR = 6174;

    public static Boolean checkNumber(Integer checkNumber) {
        if (checkNumber == null || (checkNumber > UPBORDER) || (checkNumber <= DOWNBORDER)) {
            return false;
        } else {
            for (Integer integer : UNCORRECT) {
                if (checkNumber.equals(integer)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Integer newK(Integer oldK) {
        Integer numberChange = oldK;
        List<Integer> digits = new ArrayList<>();
        while (numberChange > 0) {
            digits.add(numberChange % TEN);
            numberChange = (numberChange / TEN);
        }
        Collections.sort(digits);
        List<Integer> reverseDigits = new ArrayList<>(digits);
        Collections.reverse(digits);
        StringBuilder strDigits = new StringBuilder();
        StringBuilder strDigitsReverse = new StringBuilder();
        for (int i = 0; i < digits.size(); i++) {
            strDigits.append(digits.get(i).toString());
            strDigitsReverse.append(reverseDigits.get(i).toString());
        }
        Integer newNumb = Integer.parseInt(strDigits.toString());
        Integer newNumbReverse = Integer.parseInt(strDigitsReverse.toString());
        return (newNumb - newNumbReverse);
    }

    public static Integer countK(Integer enterNumber) {
        if (!checkNumber(enterNumber)) {
            throw  new IllegalArgumentException("Введено некорректное число!");
        } else {
            Integer count = 0;
            Integer number = enterNumber;
            while (!number.equals(KAPREKAR)) {
                number = newK(number);
                count++;
            }
            return count;
        }
    }
}
