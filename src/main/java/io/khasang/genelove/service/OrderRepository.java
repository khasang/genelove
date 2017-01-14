package io.khasang.genelove.service;

import io.khasang.genelove.model.Order;

import java.util.Map;

public interface OrderRepository {
    public void putOrder(Order order);

    public Order getOrder(String orderId);

    public Map<String, Order> getAllOrders();
}
