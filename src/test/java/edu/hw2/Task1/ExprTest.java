package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.Task1.Expr.Constant;
import edu.hw2.Task1.Expr.Addition;
import edu.hw2.Task1.Expr.Negate;
import edu.hw2.Task1.Expr.Exponent;
import edu.hw2.Task1.Expr.Multiplication;

class ExprTest {

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput(){
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour,negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        // then
        Assertions.assertThat(res.evaluate()).isEqualTo(37);
    }

}
