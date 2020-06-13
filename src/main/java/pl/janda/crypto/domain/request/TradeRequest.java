package pl.janda.crypto.domain.request;

import com.google.common.base.Preconditions;
import pl.janda.crypto.domain.account.Account;
import pl.janda.crypto.domain.account.Wallet;
import pl.janda.crypto.domain.exchange.market.Market;

import java.util.Objects;

public abstract class TradeRequest {

    private final Account account;

    private final Wallet wallet;

    private final Market market;

    private final OfferType offerType;

    public TradeRequest(Account account, Wallet wallet, Market market, OfferType offerType) {
        this.account = Preconditions.checkNotNull(account, "Account cannot be null");
        this.wallet = Preconditions.checkNotNull(wallet , "Wallet cannot be null");
        this.market = Preconditions.checkNotNull(market, "Market cannot be null");
        this.offerType = Preconditions.checkNotNull(offerType, "OfferType cannot be null");
        Preconditions.checkState(account.getWallets().contains(wallet), "Account " + account.getAccountId() + " its not wallet " + wallet.getWalletId() + " owner");
    }

    public Account getAccount() {
        return account;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Market getMarket() {
        return market;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeRequest that = (TradeRequest) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(wallet, that.wallet) &&
                Objects.equals(market, that.market) &&
                offerType == that.offerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, wallet, market, offerType);
    }
}
