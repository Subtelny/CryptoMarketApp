package pl.janda.crypto.infrastructure.exchange.bitbay;

import pl.janda.crypto.domain.exchange.market.order.RemoteOrderbook;
import pl.janda.crypto.domain.request.MakeLimitTradeRequest;
import pl.janda.crypto.domain.request.MakeFastTradeRequest;
import pl.janda.crypto.domain.exchange.ExchangeId;
import pl.janda.crypto.domain.exchange.ExternalExchange;
import pl.janda.crypto.domain.exchange.market.Market;
import pl.janda.crypto.domain.exchange.market.MarketCode;
import pl.janda.crypto.domain.exchange.market.RemoteMarket;
import pl.janda.crypto.infrastructure.exchange.bitbay.market.BitBayExternalMarket;
import pl.janda.crypto.infrastructure.exchange.bitbay.market.BitBayMarketsSync;
import pl.janda.crypto.infrastructure.exchange.bitbay.order.BitBayExternalOrderbook;
import pl.janda.crypto.infrastructure.exchange.bitbay.order.BitBayOrderbookSync;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BitBayExternalExchange implements ExternalExchange {

    public static final ExchangeId BITBAY_EXCHANGE_ID = new ExchangeId("BITBAY");

    private BitBayMarketsSync sync = new BitBayMarketsSync();

    private Map<MarketCode, Market> markets = new HashMap<>();

    @Override
    public ExchangeId getExchangeId() {
        return BITBAY_EXCHANGE_ID;
    }

    @Override
    public Collection<Market> getSyncedMarkets() {
        if (markets.isEmpty()) {
            loadMarkets();
        }
        return markets.values();
    }

    @Override
    public Market getSyncedMarket(MarketCode marketCode) {
        if (markets.isEmpty()) {
            loadMarkets();
        }
        return markets.get(marketCode);
    }

    @Override
    public void offerMarket(MakeFastTradeRequest request) {

    }

    @Override
    public void offerLimit(MakeLimitTradeRequest request) {

    }

    private void loadMarkets() {
        List<MarketCode> marketCodes = sync.getSyncedData().getMarketCodes();
        markets.putAll(marketCodes.stream()
                .collect(Collectors.toMap(code -> code, this::createRemoteMarket)));
    }

    private RemoteMarket createRemoteMarket(MarketCode marketCode) {
        BitBayExternalOrderbook externalOrderbook = new BitBayExternalOrderbook(new BitBayOrderbookSync());
        RemoteOrderbook remoteOrderbook = new RemoteOrderbook(externalOrderbook);
        BitBayExternalMarket externalMarket = new BitBayExternalMarket(marketCode);
        return new RemoteMarket(marketCode, remoteOrderbook, externalMarket);
    }

}
