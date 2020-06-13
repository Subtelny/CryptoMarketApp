package pl.janda.crypto.domain.exchange.market;

import com.google.common.base.Preconditions;
import pl.janda.crypto.domain.account.Currency;
import pl.janda.crypto.util.CompoundId;

public class MarketCode extends CompoundId {

    private static final int FIRST_CURRENCY_POSITION = 0;

    private static final int SECOND_CURRENCY_POSITION = 1;

    public MarketCode(Currency firstCurrency, Currency secondCurrency) {
        super(firstCurrency,
                secondCurrency);
        Preconditions.checkArgument(!firstCurrency.equals(secondCurrency), "Currencies cannot be the same");
    }

    public Currency getFirstCurrency() {
        return new Currency(getValueAtPosition(FIRST_CURRENCY_POSITION));
    }

    public Currency getSecondCurrency() {
        return new Currency(getValueAtPosition(SECOND_CURRENCY_POSITION));
    }

}
