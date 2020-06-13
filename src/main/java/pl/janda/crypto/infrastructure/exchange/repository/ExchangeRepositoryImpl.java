package pl.janda.crypto.infrastructure.exchange.repository;

import pl.janda.crypto.domain.exchange.Exchange;
import pl.janda.crypto.domain.exchange.ExchangeId;
import pl.janda.crypto.domain.exchange.ExchangeRepository;
import pl.janda.crypto.infrastructure.exchange.bitbay.BitBayExternalExchange;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ExchangeRepositoryImpl implements ExchangeRepository {

    private Map<ExchangeId, Exchange> exchanges = new HashMap<>();

    @Override
    public Exchange getExchange(ExchangeId exchangeId) {
        return exchanges.get(exchangeId);
    }

    @PostConstruct
    private void initializeExchanges() {
        BitBayExternalExchange bitBayExchange = new BitBayExternalExchange();
        bitBayExchange.loadMarkets();
        exchanges.put(BitBayExternalExchange.BITBAY_EXCHANGE_ID, bitBayExchange);
    }

}
