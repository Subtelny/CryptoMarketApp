package pl.janda.crypto.domain.exchange.market.order;

import java.util.List;

public class RemoteOrderbook implements Orderbook {

    private final ExternalOrderbook externalOrderbook;

    public RemoteOrderbook(ExternalOrderbook externalOrderbook) {
        this.externalOrderbook = externalOrderbook;
    }

    @Override
    public List<Order> getBuyOrders() {
        return externalOrderbook.getSyncedBuyOrders();
    }

    @Override
    public List<Order> getSellOrders() {
        return externalOrderbook.getSyncedSellOrders();
    }
}
