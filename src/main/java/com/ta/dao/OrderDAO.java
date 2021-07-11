package com.ta.dao;
import com.ta.models.Hotel;
import com.ta.models.Order;

import java.util.List;
import java.util.Optional;


public interface OrderDAO {
    void saveOrder(Order order);

    void deleteOrder(Long id);

    List<Order> getOrderByUserId(Long person_id);
}
