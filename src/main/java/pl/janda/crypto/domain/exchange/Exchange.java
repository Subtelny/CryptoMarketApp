package pl.janda.crypto.domain.exchange;

import pl.janda.crypto.domain.request.MakeFastAmountTradeRequest;
import pl.janda.crypto.domain.request.MakeFastPriceTradeRequest;
import pl.janda.crypto.domain.request.MakeLimitTradeRequest;
import pl.janda.crypto.domain.request.MakeFastTradeRequest;
import pl.janda.crypto.domain.exchange.market.Market;
import pl.janda.crypto.domain.exchange.market.MarketCode;

import java.util.Collection;

public interface Exchange {

    ExchangeId getExchangeId();

    Collection<Market> getMarkets();

    Market getMarket(MarketCode marketCode);

    void makeFastPriceTrade(MakeFastPriceTradeRequest request);

    void makeFastAmountTrade(MakeFastAmountTradeRequest request);

    void offerFastTrade(MakeFastTradeRequest request);

    void offerLimit(MakeLimitTradeRequest request);

}