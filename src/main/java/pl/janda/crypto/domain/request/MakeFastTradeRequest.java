package pl.janda.crypto.domain.request;

import com.google.common.base.Preconditions;
import pl.janda.crypto.domain.account.Account;
import pl.janda.crypto.domain.account.Wallet;
import pl.janda.crypto.domain.exchange.market.Market;

import java.util.Objects;
import java.util.Optional;

public class MakeFastTradeRequest extends TradeRequest {

    private final Double amount;

    private final Double price;

    private MakeFastTradeRequest(Account account, Wallet wallet, Market market, OfferType offerType, Double amount, Double price) {
        super(account, wallet, market, offerType);
        Preconditions.checkArgument(!(amount != null && price != null), "Cannot use amount and price at the same time");
        Preconditions.checkArgument(amount != null || price != null, "Amount or price cannot be null");
        this.amount = amount;
        this.price = price;
    }

    public static MakeFastTradeRequest amount(Account account,
                                              Wallet wallet,
                                              Market market,
                                              OfferType offerType,
                                              Double amount) {
        return new MakeFastTradeRequest(account, wallet, market, offerType, amount, null);
    }

    public static MakeFastTradeRequest price(Account account,
                                             Wallet wallet,
                                             Market market,
                                             OfferType offerType,
                                             Double price) {
        return new MakeFastTradeRequest(account, wallet, market, offerType, null, price);
    }

    public Optional<Double> getAmount() {
        return Optional.ofNullable(amount);
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MakeFastTradeRequest that = (MakeFastTradeRequest) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, price);
    }
}
