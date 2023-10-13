package edu.hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public final class Task5 {

    private Task5() {
    }

    private static final int TEN = 10;
    private static final int NINE = 9;

    public static Boolean isPalindrome(Integer checkNumber) {
        String strNumber = String.valueOf(checkNumber);
        return strNumber.contentEquals(new StringBuilder(strNumber).reverse());
    }

    public static Integer findDescendant(Integer ancestor) {
        Integer numberAncestor = ancestor;
        Stack<Integer> digits = new Stack<>();
        while (numberAncestor > 0) {
            digits.add(numberAncestor % TEN);
            numberAncestor = (numberAncestor / TEN);
        }
        if ((digits.size() % 2) > 0) {
            digits.add(0);
        }
        List<Integer> digitsDescendant = new ArrayList<>();
        while (!digits.empty()) {
            digitsDescendant.add(digits.pop() + digits.pop());
        }
        StringBuilder strDigits = new StringBuilder();
        for (Integer i : digitsDescendant) {
            strDigits.append(i.toString());
        }
        return Integer.parseInt(strDigits.toString());
    }

    public static Boolean isPalindromeDescendant(Integer enterNumber) {
        if (enterNumber == null) {
            throw  new IllegalArgumentException("Число не должно быть null!");
        } else {
            Integer number = Math.abs(enterNumber);
            while (number > NINE) {
                if (isPalindrome(number)) {
                    return true;
                } else {
                    number = findDescendant(number);
                }
            }
            return false;
        }
    }
}
