package edu.hw3;

public class Task1 {

    private Task1() {
    }

    public static int processLetter(char processedLetter) {
        int newChar;
        if (Character.isUpperCase(processedLetter)) {
            newChar = ('Z' - processedLetter) + 'A';
        } else {
            newChar = ('z' - processedLetter) + 'a';
        }
        return newChar;
    }

    public static String atbash(String sourceString) {
        if ((sourceString == null) || (sourceString.isEmpty())) {
            throw new IllegalArgumentException();
        }
        StringBuilder decoded = new StringBuilder();
        for (char letter : sourceString.toCharArray()) {
            if (Character.isLetter(letter)) {
                decoded.append((char) processLetter(letter));
            } else {
                decoded.append(letter);
            }
        }
        return decoded.toString();
    }
}
