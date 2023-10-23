package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task7Test {

    @Test
    @DisplayName("Проверка корректного вызова влево")
    void correctInputLeft(){
        // given
        Integer[] testNumbers = {6,16,28,102,48};
        Integer[] shift ={1,6,9,16,54};
        // when
        Integer[] resultTest = new Integer[testNumbers.length];
        for (int i = 0;i < testNumbers.length;i++) {
            resultTest[i] = Task7.rotateLeft(testNumbers[i],shift[i]);
        }
        // then
        Assertions.assertThat(resultTest).isEqualTo(new Integer[]{5,1,14,27,48});
    }

    @Test
    @DisplayName("Проверка корректного вызова вправо")
    void correctInputRight(){
        // given
        Integer[] testNumbers = {6,16,28,102,48};
        Integer[] shift ={1,6,9,16,54};
        // when
        Integer[] resultTest = new Integer[testNumbers.length];
        for (int i = 0;i < testNumbers.length;i++) {
            resultTest[i] = Task7.rotateRight(testNumbers[i],shift[i]);
        }
        // then
        Assertions.assertThat(resultTest).isEqualTo(new Integer[]{3,8,25,89,48});
    }
    @Test
    @DisplayName("Проверка вызова null")
    void zeroInputLeft() {
        // given
        Integer zero = null;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task7.rotateLeft(zero,4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка вызова null")
    void zeroInputRight() {
        // given
        Integer zero = null;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task7.rotateRight(4,zero)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка некорректного вызова")
    void uncorrectInputRight() {
        // given
        Integer wrongNumber = -5;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task7.rotateRight(12,wrongNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка некорректного вызова")
    void uncorrectInputLeft() {
        // given
        Integer wrongNumber = -5;
        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task7.rotateLeft(16,wrongNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}