package pl.janda.crypto.infrastructure.sockets.requests;

import pl.janda.crypto.application.ClientId;
import pl.janda.crypto.application.requests.SubscribeMarketRequest;
import pl.janda.crypto.domain.account.CurrencyType;
import pl.janda.crypto.domain.exchange.ExchangeType;
import pl.janda.crypto.domain.exchange.market.MarketCode;

import java.util.Objects;

public class SubscribeMarketSocketRequest implements SocketRequest<SubscribeMarketRequest> {

    private final ExchangeType exchangeType;

    private final CurrencyType firstCurrency;

    private final CurrencyType secondCurrency;

    public SubscribeMarketSocketRequest(ExchangeType exchangeType, CurrencyType firstCurrency, CurrencyType secondCurrency) {
        this.exchangeType = exchangeType;
        this.firstCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
    }

    @Override
    public SubscribeMarketRequest toDomain(ClientId clientId) {
        return new SubscribeMarketRequest(clientId, exchangeType, new MarketCode(firstCurrency, secondCurrency));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribeMarketSocketRequest that = (SubscribeMarketSocketRequest) o;
        return exchangeType == that.exchangeType &&
                firstCurrency == that.firstCurrency &&
                secondCurrency == that.secondCurrency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeType, firstCurrency, secondCurrency);
    }
}
