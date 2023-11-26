package edu.hw5;

public class Task6 {
    private Task6() {
    }

    public static boolean subChecker(String subSeq, String sequence) {
        char[] charsSubSeq = subSeq.toCharArray();
        StringBuilder pattern = new StringBuilder();
        pattern.append(".*");
        for (char letter : charsSubSeq) {
            pattern.append("[");
            if (letter == '\\') {
                pattern.append('\\');
            }
            pattern.append(letter);
            pattern.append("]");
            pattern.append(".*");
        }
        return sequence.matches(pattern.toString());
    }
}
