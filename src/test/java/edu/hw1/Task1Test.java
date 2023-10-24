package edu.hw1;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class Task1Test {

    @ParameterizedTest
    @ValueSource(strings = {"22:45"})
    void testCorrectInput(String argument) {
        // given

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(argument);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(1365);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"aa:bb", "22:88", "22:-45","-22:45"})
    void testUncorrectInput(String argument) {
        Assertions.assertThatThrownBy(()->
                Task1.minutesToSeconds(argument)).isInstanceOf(IllegalArgumentException.class);
    }
}