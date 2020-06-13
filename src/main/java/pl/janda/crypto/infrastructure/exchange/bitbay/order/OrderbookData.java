package pl.janda.crypto.infrastructure.exchange.bitbay.order;

import pl.janda.crypto.domain.exchange.market.order.Order;

import java.util.List;
import java.util.Objects;

public class OrderbookData {

    private final List<Order> buyOrders;

    private final List<Order> sellOrders;

    public OrderbookData(List<Order> buyOrders, List<Order> sellOrders) {
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
    }

    public List<Order> getBuyOrders() {
        return buyOrders;
    }

    public List<Order> getSellOrders() {
        return sellOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderbookData that = (OrderbookData) o;
        return Objects.equals(buyOrders, that.buyOrders) &&
                Objects.equals(sellOrders, that.sellOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyOrders, sellOrders);
    }
}
