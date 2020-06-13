package pl.janda.crypto.domain.exchange;

import pl.janda.crypto.domain.exchange.ExchangeType;
import pl.janda.crypto.util.SimpleId;

public class ExchangeId extends SimpleId<String> {

    public ExchangeId(ExchangeType exchangeType) {
        this(exchangeType.name());
    }

    public ExchangeId(String internal) {
        super(internal);
    }

    public ExchangeType getExchangeType() {
        return ExchangeType.valueOf(getInternal());
    }

}
