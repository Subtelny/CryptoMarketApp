package pl.janda.crypto.domain.request;

import com.google.common.base.Preconditions;
import pl.janda.crypto.domain.account.Account;
import pl.janda.crypto.domain.account.Wallet;
import pl.janda.crypto.domain.exchange.market.Market;

public class MakeFastPriceTradeRequest extends ValueTradeRequest {

    public MakeFastPriceTradeRequest(Account account, Wallet wallet, Market market, OfferType offerType, Double price) {
        super(account, wallet, market, offerType, Preconditions.checkNotNull(price, "Price cannot be null"));
    }

}
