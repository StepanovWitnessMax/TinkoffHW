package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task5Test {

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        // given
        Integer[] testNumbers = {1234567890,99998888,11211230,13001120,23336014,11,-12345};

        // when
        Boolean[] resultTest = new Boolean[testNumbers.length];
        for (int i = 0;i < testNumbers.length;i++) {
            resultTest[i] = Task5.isPalindromeDescendant(testNumbers[i]);
        }
        // then
        Assertions.assertThat(resultTest).isEqualTo(new Boolean[]{false,false,true,true,true,true,false});
    }

    @Test
    @DisplayName("Проверка вызова null")
    void zeroInput() {
        // given
        Integer zero = null;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task5.isPalindromeDescendant(zero)).isInstanceOf(IllegalArgumentException.class);
    }
}
