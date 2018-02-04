package com.how2java.service;

import com.how2java.pojo.Order;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    List<Order> getOrderByUserId(int userId, int status);

    int orderNow(Order order);

    int updateOrder(Order order);

}
