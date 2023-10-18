package edu.hw1;


public final class Task4 {

    private Task4() {
    }

    public static String fixString(String brokenString) {
        if (brokenString == null) {
            throw new IllegalArgumentException("Строка не должна быть null!");
        } else {
            char[] fixedChar = brokenString.toCharArray();
            char swap;
            for (int i = 0; i < fixedChar.length - 1; i += 2) {
                swap = fixedChar[i];
                fixedChar[i] = fixedChar[i + 1];
                fixedChar[i + 1] = swap;
            }
            return String.valueOf(fixedChar);
        }
    }
}
