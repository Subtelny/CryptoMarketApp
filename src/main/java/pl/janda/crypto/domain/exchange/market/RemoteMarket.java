package pl.janda.crypto.domain.exchange.market;

import pl.janda.crypto.domain.exchange.market.order.Orderbook;

public class RemoteMarket implements Market {

    private final MarketCode marketCode;

    private final Orderbook orderbook;

    private final ExternalMarket externalMarket;

    public RemoteMarket(MarketCode marketCode, Orderbook orderbook, ExternalMarket externalMarket) {
        this.marketCode = marketCode;
        this.orderbook = orderbook;
        this.externalMarket = externalMarket;
    }

    @Override
    public MarketCode getCode() {
        return marketCode;
    }

    @Override
    public Orderbook getOrderbook() {
        return orderbook;
    }

    @Override
    public double getCurrentHighestBid() {
        return externalMarket.getSyncedCurrentHighestBid();
    }

    @Override
    public double getCurrentLowestAsk() {
        return externalMarket.getSyncedCurrentLowestAsk();
    }

    @Override
    public double getLatestRate() {
        return externalMarket.getSyncedLatestRate();
    }

    @Override
    public double getPreviousRate() {
        return externalMarket.getSyncedPreviousRate();
    }

    @Override
    public double getDailyHighestBid() {
        return externalMarket.getSyncedDailyHighestBid();
    }

    @Override
    public double getDailyLowestAsk() {
        return externalMarket.getSyncedDailyLowestAsk();
    }

    @Override
    public double getDailyAverageRate() {
        return externalMarket.getSyncedDailyAverageRate();
    }
}
