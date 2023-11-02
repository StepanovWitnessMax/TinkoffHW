package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockMarket implements StockMarketInterface {

    private final PriorityQueue<Stock> stockPriorityQueue =
        new PriorityQueue<>(Comparator.comparingInt(Stock::getPrice).reversed());

    public void add(Stock stock) {
        stockPriorityQueue.add(stock);
    }

    public void remove(Stock stock) {
        stockPriorityQueue.remove(stock);
    }

    public Stock mostValuableStock() {
        return stockPriorityQueue.peek();
    }
}
