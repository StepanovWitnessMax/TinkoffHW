package edu.hw3.Task6;

public class Stock {

    private final Integer price;
    private final String name;

    public Stock(Integer price, String name) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Stock comparisonObj)) {
            return false;
        }
        return (this.price.equals(comparisonObj.price) && this.name.equals(comparisonObj.name));
    }

    @Override
    public int hashCode() {
        return this.price * 3 + this.name.length();
    }

}
