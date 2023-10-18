package edu.hw1;

public final class Task1 {

    private Task1() {
    }

    private static final int SECONDSINMINUTE = 60;
    private static final String UNCORRECT_INPUT = "Введено некорректное время!";

    public static Integer minutesToSeconds(String enteredTime) {
        if (enteredTime == null) {
            throw new IllegalArgumentException(UNCORRECT_INPUT);
        } else {
            String[] enterTime = enteredTime.split(":");
            if (enterTime[0].matches("\\d+") && (enterTime[1].matches("\\d\\d")
                    && (Integer.parseInt(enterTime[1]) < SECONDSINMINUTE))) {
                return Integer.parseInt(enterTime[0]) * SECONDSINMINUTE + Integer.parseInt(enterTime[1]);
            } else {
                throw new IllegalArgumentException(UNCORRECT_INPUT);
            }
        }
    }
}
