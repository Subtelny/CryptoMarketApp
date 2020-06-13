package pl.janda.crypto.infrastructure.exchange.bitbay.order;

import pl.janda.crypto.infrastructure.exchange.HttpDataSync;

public class BitBayOrderbookSync extends HttpDataSync<OrderbookData> {

    private static final int ORDERBOOK_OUTDATED_SECONDS = 1;

    private static final String ORDERBOOK_URL = "https://api.bitbay.net/rest/trading/orderbook";

    @Override
    protected OrderbookData syncData() {
        String json = sendRequest(ORDERBOOK_URL);
        return parseJsonIntoData(json, OrderbookDTO.class).toOrderbookData();
    }

    @Override
    protected int outdatedEverySeconds() {
        return ORDERBOOK_OUTDATED_SECONDS;
    }
}
