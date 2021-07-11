package com.ta.service.impl;
import com.ta.dao.OrderDAO;
import com.ta.models.Hotel;
import com.ta.models.Order;
import com.ta.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Transactional
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    @Override
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    public List<Order> getOrderByUserId(Long person_id) {
        return orderDAO.getOrderByUserId(person_id);
    }
}
