package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task3Test {
    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        // given
        Integer[][] firstArray={{1, 2, 3, 4},{3, 1},{9, 9, 8},{1, 2, -3, 4}};
        Integer[][] secondArray = {{0,6},{4,0},{8,9},{-1,0,0,0,0,0}};

        // when

        Boolean[] outputList = new Boolean[firstArray.length];
        for (int i = 0;i < firstArray.length;i++) {
            outputList[i] = Task3.isNestable(firstArray[i],secondArray[i]);
        }
        // then
        Assertions.assertThat(outputList).isEqualTo(new Boolean[]{true,true,false,false});
    }

    @Test
    @DisplayName("Проверка массива null и инициализированного не заполненного массива")
    void voidInput(){
        // given
        Integer[][] firstArray={{1, 2, 3, 4},{3, 1}};
        Integer[][] secondArray = {new Integer[5],null};

        // when

        Boolean[] outputList = new Boolean[firstArray.length];
        for (int i = 0;i < firstArray.length;i++) {
            outputList[i] = Task3.isNestable(firstArray[i],secondArray[i]);
        }
        // then
        Assertions.assertThat(outputList).isEqualTo(new Boolean[]{false,false});
    }

    @Test
    @DisplayName("Проверка пустого массива")
    void emptyInput(){
        // given
        Integer[] firstArray = {1, 2, 3, 4};
        Integer[] secondArray = {};

        // when

        Boolean outputAnswer = Task3.isNestable(firstArray,secondArray);
        // then
        Assertions.assertThat(outputAnswer).isEqualTo(false);
    }

}