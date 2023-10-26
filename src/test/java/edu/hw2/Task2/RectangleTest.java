package edu.hw2.Task2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class RectangleTest {

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(0,0)),
            Arguments.of(new Square(0))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        assertThat(rect.setHeight(10).setWidth(20).area()).isEqualTo(200.0);
    }

}
