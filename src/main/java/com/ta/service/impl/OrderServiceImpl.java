package com.ta.service.impl;
import com.ta.dao.OrderDAO;
import com.ta.models.Order;
import com.ta.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Transactional
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;


    @Override
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
        //return true;
    }
}
