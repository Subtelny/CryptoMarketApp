package pl.janda.crypto.domain.request;

import pl.janda.crypto.domain.account.Account;
import pl.janda.crypto.domain.account.Wallet;
import pl.janda.crypto.domain.exchange.market.Market;

import java.util.Objects;
import java.util.Optional;

public class MakeLimitTradeRequest extends TradeRequest {

    private final Double amount;

    private final Double price;

    private final Double rate;

    public MakeLimitTradeRequest(Account account, Wallet wallet, Market market, OfferType offerType, Double amount,
                                 Double price, Double rate) {
        super(account, wallet, market, offerType);
        this.amount = amount;
        this.price = price;
        this.rate = rate;
    }

    public static MakeLimitTradeRequest amount(Account account,
                                               Wallet wallet,
                                               Market market,
                                               OfferType offerType,
                                               Double amount,
                                               Double rate) {
        return new MakeLimitTradeRequest(account, wallet, market, offerType, amount, null, rate);
    }

    public static MakeLimitTradeRequest price(Account account,
                                              Wallet wallet,
                                              Market market,
                                              OfferType offerType,
                                              Double price,
                                              Double rate) {
        return new MakeLimitTradeRequest(account, wallet, market, offerType, null, price, rate);
    }

    public Optional<Double> getAmount() {
        return Optional.ofNullable(amount);
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MakeLimitTradeRequest that = (MakeLimitTradeRequest) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(price, that.price) &&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, price, rate);
    }
}
