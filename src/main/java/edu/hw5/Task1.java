package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Task1 {
    private Task1() {
    }

    private static final int MINUTES_IN_HOUR = 60;
    private static final String PATTERN_FOR_TIME = "yyyy-MM-dd, HH:mm";
    private static final String INPUT_ILLEGAL_FORMAT_TIME = "Incorrect time format has been entered";
    private static final String SEPARATOR = " - ";

    public static String averageTime(List<String> listTimeString) {
        if ((listTimeString == null) || (listTimeString.isEmpty())) {
            throw new IllegalArgumentException(INPUT_ILLEGAL_FORMAT_TIME);
        }
        Duration timeSum = Duration.ofDays(0);
        for (String timeString : listTimeString) {
            String startTimeString = timeString.split(SEPARATOR)[0];
            String endTimeString = timeString.split(SEPARATOR)[1];
            LocalDateTime startTime;
            LocalDateTime endTime;
            try {
                startTime = LocalDateTime.parse(startTimeString, DateTimeFormatter.ofPattern(PATTERN_FOR_TIME));
                endTime = LocalDateTime.parse(endTimeString, DateTimeFormatter.ofPattern(PATTERN_FOR_TIME));
            } catch (DateTimeParseException e) {
                return INPUT_ILLEGAL_FORMAT_TIME;
            }
            if (startTime.isAfter(endTime)) {
                return INPUT_ILLEGAL_FORMAT_TIME;
            }
            timeSum = timeSum.plus(Duration.between(startTime, endTime));
        }
        var averageTime = timeSum.dividedBy(listTimeString.size());
        return averageTime.toHours() + "ч " + averageTime.toMinutes() % MINUTES_IN_HOUR + "м";
    }
}
