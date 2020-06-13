package pl.janda.crypto.domain.exchange;

import com.google.common.base.Preconditions;
import pl.janda.crypto.domain.exchange.market.Market;
import pl.janda.crypto.domain.exchange.market.MarketCode;
import pl.janda.crypto.domain.request.*;

import java.util.Collection;

public class RemoteExchange implements Exchange {

    private final ExchangeId exchangeId;

    private final ExternalExchange externalExchange;

    public RemoteExchange(ExchangeId exchangeId, ExternalExchange externalExchange) {
        this.exchangeId = exchangeId;
        this.externalExchange = externalExchange;
    }

    @Override
    public ExchangeId getExchangeId() {
        return exchangeId;
    }

    @Override
    public Collection<Market> getMarkets() {
        return externalExchange.getSyncedMarkets();
    }

    @Override
    public Market getMarket(MarketCode marketCode) {
        return externalExchange.getSyncedMarket(marketCode);
    }

    @Override
    public void makeFastPriceTrade(MakeFastPriceTradeRequest request) {
        validateTradeRequest(request);
        Market market = request.getMarket();
    }

    @Override
    public void makeFastAmountTrade(MakeFastAmountTradeRequest request) {

    }

    @Override
    public void offerFastTrade(MakeFastTradeRequest request) {
        validateTradeRequest(request);
        Market market = request.getMarket();

        externalExchange.offerMarket(request);
    }

    private void validateTradeRequest(TradeRequest request) {
        Market market = request.getMarket();
        Preconditions.checkState(getMarkets().contains(market), "Not found market " + market.getCode() + " at exchange " + exchangeId);
    }

    @Override
    public void offerLimit(MakeLimitTradeRequest request) {


        externalExchange.offerLimit(request);
    }
}
