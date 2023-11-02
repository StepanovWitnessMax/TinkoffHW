package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {

        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr value) implements Expr {

        @Override
        public double evaluate() {
            return (-1 * value.evaluate());
        }
    }

    public record Exponent(Expr exp, Expr degree) implements Expr {
        public Exponent(Expr exp, double degree) {
            this(exp, new Constant(degree));
        }

        @Override
        public double evaluate() {
            return Math.pow(exp.evaluate(), degree.evaluate());
        }
    }

    public record Addition(Expr summand, Expr addend) implements Expr {

        @Override
        public double evaluate() {
            return (summand.evaluate() + addend.evaluate());
        }
    }

    public record Multiplication(Expr firstMultiplier, Expr secondMultiplier) implements Expr {

        @Override
        public double evaluate() {
            return (firstMultiplier.evaluate() * secondMultiplier.evaluate());
        }
    }
}
