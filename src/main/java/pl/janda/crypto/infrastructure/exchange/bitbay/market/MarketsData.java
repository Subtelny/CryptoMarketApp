package pl.janda.crypto.infrastructure.exchange.bitbay.market;

import pl.janda.crypto.domain.exchange.market.MarketCode;

import java.util.List;

public class MarketsData {

    private final List<MarketCode> marketCodes;

    public MarketsData(List<MarketCode> marketCodes) {
        this.marketCodes = marketCodes;
    }

    public List<MarketCode> getMarketCodes() {
        return marketCodes;
    }
}
