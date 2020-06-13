package pl.janda.crypto.domain.request;

import pl.janda.crypto.domain.account.Account;
import pl.janda.crypto.domain.account.Wallet;
import pl.janda.crypto.domain.exchange.market.Market;

import java.util.Objects;

public abstract class ValueTradeRequest extends TradeRequest {

    private final Double value;

    public ValueTradeRequest(Account account, Wallet wallet, Market market, OfferType offerType, Double value) {
        super(account, wallet, market, offerType);
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ValueTradeRequest that = (ValueTradeRequest) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
