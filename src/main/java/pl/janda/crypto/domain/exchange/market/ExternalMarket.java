package pl.janda.crypto.domain.exchange.market;

public interface ExternalMarket {

    MarketCode getCode();

    double getSyncedCurrentHighestBid();

    double getSyncedCurrentLowestAsk();

    double getSyncedLatestRate();

    double getSyncedPreviousRate();

    double getSyncedDailyHighestBid();

    double getSyncedDailyLowestAsk();

    double getSyncedDailyAverageRate();

}
