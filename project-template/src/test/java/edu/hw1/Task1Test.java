package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task1Test {
@Test
@DisplayName("Проверка корректного вызова")
    void correctInput(){
    // given
    String enteredTime ="22:45";

    // when
    Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

    // then
    Assertions.assertThat(timeInSeconds).isEqualTo(1365);
    }

    @Test
    @DisplayName("Проверка вхождения нулей")
    void zeroEnter(){
        // given
        String enteredTime ="00:00";

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(0);
    }

    @Test
    @DisplayName("Проверка вхождения пустой строки")
    void emptyInput(){
        // given
        String enteredTime ="";

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка вхождения отрицательного времени")
    void negativeInputHours(){
        // given
        String enteredTime ="-22:45";

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка вхождения отрицательного времени")
    void negativeInputSeconds(){
        // given
        String enteredTime ="22:-45";

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка выхода секунд за границы минуты")
    void incorrectInputSeconds(){
        // given
        String enteredTime ="22:88";

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка введения букв")
    void incorrectInput(){
        // given
        String enteredTime ="aa:bb";

        // when
        Integer timeInSeconds = Task1.minutesToSeconds(enteredTime);

        // then
        Assertions.assertThat(timeInSeconds).isEqualTo(-1);
    }
}