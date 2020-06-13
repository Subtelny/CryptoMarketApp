package pl.janda.crypto.infrastructure.exchange.bitbay.market;

import pl.janda.crypto.domain.exchange.market.ExternalMarket;
import pl.janda.crypto.domain.exchange.market.MarketCode;
import pl.janda.crypto.infrastructure.exchange.bitbay.ticker.BitBayTickerSync;

public class BitBayExternalMarket implements ExternalMarket {

    private final MarketCode marketCode;

    private final BitBayTickerSync tickerSync;

    public BitBayExternalMarket(MarketCode marketCode) {
        this.marketCode = marketCode;
        this.tickerSync = new BitBayTickerSync(marketCode);
    }

    @Override
    public MarketCode getCode() {
        return marketCode;
    }

    @Override
    public double getSyncedCurrentHighestBid() {
        return tickerSync.getSyncedData().getHighestBid();
    }

    @Override
    public double getSyncedCurrentLowestAsk() {
        return tickerSync.getSyncedData().getLowestAsk();
    }

    @Override
    public double getSyncedLatestRate() {
        return tickerSync.getSyncedData().getRate();
    }

    @Override
    public double getSyncedPreviousRate() {
        return tickerSync.getSyncedData().getPreviousRate();
    }

    @Override
    public double getSyncedDailyHighestBid() {
        return 0;
    }

    @Override
    public double getSyncedDailyLowestAsk() {
        return 0;
    }

    @Override
    public double getSyncedDailyAverageRate() {
        return 0;
    }


}
