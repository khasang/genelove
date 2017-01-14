package io.khasang.genelove.service;

import io.khasang.genelove.model.InventoryResponse;
import io.khasang.genelove.model.Order;

import java.util.Map;

public interface OrderService {
    public void sendOrder(Order order);

    public void updateOrder(InventoryResponse response);

    public Map<String, Order> getAllOrders();
}
