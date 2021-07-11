package com.ta.service;
import com.ta.models.Order;

import java.util.List;


public interface OrderService {
    void saveOrder(Order order);

    void deleteOrder(Long id);

    List<Order> getOrderByUserId(Long person_id);
}
