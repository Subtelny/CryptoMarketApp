package pl.janda.crypto.domain.exchange.market.order;

import java.util.List;

public interface ExternalOrderbook {

    List<Order> getSyncedBuyOrders();

    List<Order> getSyncedSellOrders();

}
