package pl.janda.crypto.domain.exchange.market.order;

import java.util.List;

public interface Orderbook {

    List<Order> getBuyOrders();

    List<Order> getSellOrders();

}
