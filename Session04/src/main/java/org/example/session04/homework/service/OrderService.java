package org.example.session04.homework.service;


import org.example.session04.homework.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public String getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public String getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }
}
