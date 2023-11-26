package edu.hw5;

public class Task5 {
    private Task5() {
    }

    public static boolean checkValidCarNumber(String carNumber) {
        return carNumber.matches("^[АВЕКМНОРСТУХ](?!000)\\d{3}[АВЕКМНОРСТУХ]{2}((?!00)\\d{2}|[1-9]\\d{2})$");
    }
}
