package pl.janda.crypto.domain.exchange;

import pl.janda.crypto.domain.request.MakeLimitTradeRequest;
import pl.janda.crypto.domain.request.MakeFastTradeRequest;
import pl.janda.crypto.domain.exchange.market.Market;
import pl.janda.crypto.domain.exchange.market.MarketCode;

import java.util.Collection;

public interface ExternalExchange {

    ExchangeId getExchangeId();

    Collection<Market> getSyncedMarkets();

    Market getSyncedMarket(MarketCode marketCode);

    void offerMarket(MakeFastTradeRequest request);

    void offerLimit(MakeLimitTradeRequest request);

}
