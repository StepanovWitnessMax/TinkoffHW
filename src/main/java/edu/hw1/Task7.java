package edu.hw1;

public final class Task7 {

    private static final String INPUTERROR = "Введено некорректное число!";

    private Task7() {
    }

    public static Boolean checkNumber(Integer checkNumber) {
        return  ((checkNumber == null) || (checkNumber <= 0));
    }

    public static Integer rotateLeft(Integer enterNumber, Integer shift) {
        if (checkNumber(enterNumber) || checkNumber(shift)) {
            throw  new IllegalArgumentException(INPUTERROR);
        } else {
            String stringNumber = Integer.toBinaryString(enterNumber);
            Integer realShift = shift;
            if (shift > stringNumber.length()) {
                realShift = shift % stringNumber.length();
            }
            String newStrNumber = stringNumber.substring(realShift)
                    + stringNumber.substring(0, realShift);
            return Integer.parseInt(newStrNumber, 2);
        }
    }

    public static Integer rotateRight(Integer enterNumber, Integer shift) {
        if (checkNumber(enterNumber) || checkNumber(shift)) {
            throw  new IllegalArgumentException(INPUTERROR);
        } else {
            String stringNumber = Integer.toBinaryString(enterNumber);
            Integer realShift = shift;
            if (shift > stringNumber.length()) {
                realShift = shift % stringNumber.length();
            }
            String newStrNumber = stringNumber.substring(stringNumber.length() - realShift)
                    + stringNumber.substring(0, stringNumber.length() - realShift);
            return Integer.parseInt(newStrNumber, 2);
        }
    }
}
