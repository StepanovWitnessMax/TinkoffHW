package edu.hw1;

public final class Task1 {

    private Task1() {
    }

    private static final int SECONDSINMINUTE = 60;

    public static Integer minutesToSeconds(String enteredTime) {
        String[] enterTime = enteredTime.split(":");
        if (enterTime[0].matches("\\d+") && (enterTime[1].matches("\\d\\d")
                && (Integer.parseInt(enterTime[1]) < SECONDSINMINUTE))) {
            return Integer.parseInt(enterTime[0]) * SECONDSINMINUTE + Integer.parseInt(enterTime[1]);
        } else {
            return -1;
        }
    }
}
