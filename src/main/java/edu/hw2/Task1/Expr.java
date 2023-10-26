package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {

        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Constant constant) implements Expr {

        @Override
        public double evaluate() {
            return (-1 * constant.evaluate());
        }
    }

    public record Exponent(Multiplication exp, Constant constant) implements Expr {
        public Exponent(Multiplication exp, double value) {
            this(exp, new Constant(value));
        }

        @Override
        public double evaluate() {
            return Math.pow(exp.evaluate(), constant.evaluate());
        }
    }

    public record Addition(Constant summand, Constant addend) implements Expr {
        public Addition(Exponent summand, Constant addend) {
            this(new Constant(summand.evaluate()), addend);
            //this.addition=summand.value + addend.value;
        }

        @Override
        public double evaluate() {
            return (summand.evaluate() + addend.evaluate());
        }
    }

    public record Multiplication(Addition firstMultiplier, Negate secondMultiplier) implements Expr {

        @Override
        public double evaluate() {
            return (firstMultiplier.evaluate() * secondMultiplier.evaluate());
        }
    }
}
