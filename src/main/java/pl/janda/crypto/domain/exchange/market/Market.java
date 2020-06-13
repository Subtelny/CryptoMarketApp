package pl.janda.crypto.domain.exchange.market;

import pl.janda.crypto.domain.exchange.market.order.Orderbook;

public interface Market {

    MarketCode getCode();

    Orderbook getOrderbook();

    double getCurrentHighestBid();

    double getCurrentLowestAsk();

    double getLatestRate();

    double getPreviousRate();

    double getDailyHighestBid();

    double getDailyLowestAsk();

    double getDailyAverageRate();

}
