package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task2Test {
    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        // given
        Integer[] enterNumber = {0,1,2345,-64353352,1000000000};

        // when
        Integer[] digitsInNumbers = new Integer[enterNumber.length];
        for (int i = 0;i < enterNumber.length;i++) {
            digitsInNumbers[i] = Task2.countDigits(enterNumber[i]);
        }
        // then
        Assertions.assertThat(digitsInNumbers).isEqualTo(new Integer[]{1,1,4,8,10});
    }

    @Test
    @DisplayName("Проверка вызова с null")
    void zeroInput(){
        // given
        Integer enterNumber = null;

        // when
        Integer digitsInNumbers = Task2.countDigits(enterNumber);

        // then
        Assertions.assertThat(digitsInNumbers).isEqualTo(-1);
    }

}