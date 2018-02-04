package com.how2java.service.impl;

import com.how2java.mapper.OrderMapper;
import com.how2java.pojo.Order;
import com.how2java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public void insert(Order order) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public Order query(int id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }


    @Override
    public List<Order> getOrderByUserId(int userId, int status) {
        return orderMapper.getOrderByUserId(userId, status);
    }

    @Override
    public int orderNow(Order order) {
        return orderMapper.orderNow(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }
}
