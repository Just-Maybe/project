package com.how2java.mapper;

import com.how2java.base.BaseMapper;
import com.how2java.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderMapper extends BaseMapper<Order> {
    List<Order> getOrderByUserId(@Param("userId") int userId, @Param("status") int status);

    int orderNow(Order order);

    int updateOrder(Order order);
}
