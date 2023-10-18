package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task8Test {

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        // given
        Integer[][] testBoard1 = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
        };
        Integer[][] testBoard2= {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
        };
        Integer[][] testBoard3= {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        // when
        Boolean[] resultTest = new Boolean[3];
        resultTest[0]=Task8.knightBoardCapture(testBoard1);
        resultTest[1]=Task8.knightBoardCapture(testBoard2);
        resultTest[2]=Task8.knightBoardCapture(testBoard3);
        // then
        Assertions.assertThat(resultTest).isEqualTo(new Boolean[]{true,false,false});
    }

    @Test
    @DisplayName("Проверка вызова null")
    void zeroInput() {
        // given
        Integer[][] zero = null;

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task8.knightBoardCapture(zero)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка некорректных значений на доске")
    void uncorrectInBoard() {
        // given
        Integer[][] testBoard = {
                {5, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
        };

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task8.knightBoardCapture(testBoard)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка обработки null на доске")
    void zeroInBoard() {
        // given
        Integer[][] testBoard = {
                {0, 0, null, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
        };

        // when
        // then
        Assertions.assertThatThrownBy(()->
            Task8.knightBoardCapture(testBoard)).isInstanceOf(IllegalArgumentException.class);
    }
}