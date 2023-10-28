package edu.hw3.Task6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StockMarketTest {


    @Test
    @DisplayName("Проверка корректной работы биржи")
    void correctInput(){
        // given
        StockMarket stockMarket = new StockMarket();
        stockMarket.add(new Stock(30, "Stock1"));
        stockMarket.add(new Stock(10, "Stock2"));
        stockMarket.add(new Stock(20, "Stock3"));
        // when
        Stock mostValuableStock = stockMarket.mostValuableStock();
        // then
        Assertions.assertThat(mostValuableStock).isEqualTo(new Stock(30,"Stock1"));
        stockMarket.remove(new Stock(30,"Stock1"));
        Stock mostValuableStockAfterRemove = stockMarket.mostValuableStock();
        Assertions.assertThat(mostValuableStockAfterRemove).isEqualTo(new Stock(20,"Stock3"));
        stockMarket.add(new Stock(100,"Stock4"));
        Stock mostValuableStockAfterAdd = stockMarket.mostValuableStock();
        Assertions.assertThat(mostValuableStockAfterAdd).isEqualTo(new Stock(100,"Stock4"));
    }

}
