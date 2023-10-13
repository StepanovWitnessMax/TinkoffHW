package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task6Test {

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        // given
        Integer[] testNumbers = {6621,6554,1234,3524};

        // when
        Integer[] resultTest = new Integer[testNumbers.length];
        for (int i = 0;i < testNumbers.length;i++) {
            resultTest[i] = Task6.countK(testNumbers[i]);
        }
        // then
        Assertions.assertThat(resultTest).isEqualTo(new Integer[]{5,4,3,3});
    }

    @Test
    @DisplayName("Проверка вызова null")
    void zeroInput() {
        // given
        Integer zero = null;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task6.countK(zero)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка некорректного вызова")
    void uncorrectInput1() {
        // given
        Integer wrongNumber = 1000;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task6.countK(wrongNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка некорректного вызова")
    void uncorrectInput2() {
        // given
        Integer wrongNumber = 8888;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task6.countK(wrongNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка некорректного вызова")
    void uncorrectInput3() {
        // given
        Integer wrongNumber = 15000;
        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task6.countK(wrongNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}