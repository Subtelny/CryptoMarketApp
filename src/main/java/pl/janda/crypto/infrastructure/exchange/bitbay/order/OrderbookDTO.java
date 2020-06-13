package pl.janda.crypto.infrastructure.exchange.bitbay.order;

import pl.janda.crypto.domain.exchange.market.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderbookDTO {

    public List<OrderDTO> sell = new ArrayList<>();

    public List<OrderDTO> buy = new ArrayList<>();

    public OrderbookData toOrderbookData() {
        List<Order> sellOrder = sell.stream().map(this::createOrder).collect(Collectors.toList());
        List<Order> buyOrder = buy.stream().map(this::createOrder).collect(Collectors.toList());
        return new OrderbookData(buyOrder, sellOrder);
    }

    private Order createOrder(OrderDTO orderDTO) {
        return new Order(orderDTO.ra, orderDTO.ca, orderDTO.sa, orderDTO.pa, orderDTO.co);
    }

}
