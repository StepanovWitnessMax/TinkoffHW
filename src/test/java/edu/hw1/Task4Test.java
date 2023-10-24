package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task4Test {

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        // given
        String[] testStrings = {"2143658709","","hTsii  s aimex dpus rtni.g","badce"};

        // when
        String[] fixedStrings = new String[testStrings.length];
        for (int i = 0;i < testStrings.length;i++) {
            fixedStrings[i] = Task4.fixString(testStrings[i]);
        }
        // then
        Assertions.assertThat(fixedStrings).isEqualTo(new String[]{"1234567890","","This is a mixed up string.","abcde"});
    }

    @Test
    @DisplayName("Проверка вызова строки null")
    void zeroInput() {
        // given
        String zero = null;

        // when
        // then
        Assertions.assertThatThrownBy(() -> Task4.fixString(zero)).isInstanceOf(IllegalArgumentException.class);
    }
}
