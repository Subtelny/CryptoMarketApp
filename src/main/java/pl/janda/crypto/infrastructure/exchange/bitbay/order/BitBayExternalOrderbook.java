package pl.janda.crypto.infrastructure.exchange.bitbay.order;

import pl.janda.crypto.domain.exchange.market.order.ExternalOrderbook;
import pl.janda.crypto.domain.exchange.market.order.Order;

import java.util.List;

public class BitBayExternalOrderbook implements ExternalOrderbook {

    private final BitBayOrderbookSync sync;

    public BitBayExternalOrderbook(BitBayOrderbookSync sync) {
        this.sync = sync;
    }

    @Override
    public List<Order> getSyncedBuyOrders() {
        return sync.getSyncedData().getBuyOrders();
    }

    @Override
    public List<Order> getSyncedSellOrders() {
        return sync.getSyncedData().getSellOrders();
    }
}
