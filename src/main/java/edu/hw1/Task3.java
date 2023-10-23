package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public final class Task3 {

    private Task3() {
    }

    public static Boolean isNestable(Integer[] firstArray, Integer[] secondArray) {
        if ((firstArray == null) || (secondArray == null)
                || (firstArray.length == 0) || (secondArray.length == 0)) {
            return false;
        } else if (Arrays.stream(firstArray).allMatch(Objects::nonNull)
                && Arrays.stream(secondArray).allMatch(Objects::nonNull)) {
            Integer maxFirstArray = Arrays.stream(firstArray).max(Comparator.naturalOrder()).get();
            Integer minFirstArray = Arrays.stream(firstArray).min(Comparator.naturalOrder()).get();
            Integer maxSecondArray = Arrays.stream(secondArray).max(Comparator.naturalOrder()).get();
            Integer minSecondArray = Arrays.stream(secondArray).min(Comparator.naturalOrder()).get();
            return ((minFirstArray > minSecondArray) && (maxFirstArray < maxSecondArray));
        } else {
            return false;
        }
    }
}
