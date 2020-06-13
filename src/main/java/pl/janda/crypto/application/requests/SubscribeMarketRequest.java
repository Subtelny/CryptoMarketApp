package pl.janda.crypto.application.requests;

import pl.janda.crypto.application.ClientId;
import pl.janda.crypto.domain.exchange.ExchangeType;
import pl.janda.crypto.domain.exchange.market.MarketCode;

import java.util.Objects;

public class SubscribeMarketRequest {

    private final ClientId clientId;

    private final ExchangeType exchangeType;

    private final MarketCode marketCode;

    public SubscribeMarketRequest(ClientId clientId, ExchangeType exchangeType, MarketCode marketCode) {
        this.clientId = clientId;
        this.exchangeType = exchangeType;
        this.marketCode = marketCode;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public MarketCode getMarketCode() {
        return marketCode;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribeMarketRequest that = (SubscribeMarketRequest) o;
        return Objects.equals(clientId, that.clientId) &&
                exchangeType == that.exchangeType &&
                Objects.equals(marketCode, that.marketCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, exchangeType, marketCode);
    }
}
