package edu.hw1;

public final class Task2 {

    private Task2() {
    }

    private static final int SHIFTTHREE = 3;
    private static final int SHIFTONE = 1;
    private static final int NINE = 9;

    public static Integer countDigits(Integer enterNumber) {
        if (enterNumber == null) {
            return -1;
        } else if (!enterNumber.equals(0)) {
            int number = Math.abs(enterNumber);
            Integer countDigit = 0;
            for (int shift = 0; number > shift; ++countDigit) {
                shift = (shift << SHIFTTHREE) + (shift << SHIFTONE) + NINE;
            }
            return countDigit;
        } else {
            return 1;
        }
    }
}
