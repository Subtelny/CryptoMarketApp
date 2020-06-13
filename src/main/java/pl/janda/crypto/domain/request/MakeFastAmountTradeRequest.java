package pl.janda.crypto.domain.request;

import com.google.common.base.Preconditions;
import pl.janda.crypto.domain.account.Account;
import pl.janda.crypto.domain.account.Wallet;
import pl.janda.crypto.domain.exchange.market.Market;

public class MakeFastAmountTradeRequest extends ValueTradeRequest {

    public MakeFastAmountTradeRequest(Account account, Wallet wallet, Market market, OfferType offerType, Double amount) {
        super(account, wallet, market, offerType, Preconditions.checkNotNull(amount, "Amount cannot be null"));
    }

}
