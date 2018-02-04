package com.how2java.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.Constant;
import com.how2java.pojo.JsonResponse;
import com.how2java.pojo.Order;
import com.how2java.service.OrderService;
import com.how2java.service.RoomService;
import com.how2java.utils.OrderNoUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/order")
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/getOrderByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<List<Order>> getOrderByUserId(int userId, int status, @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        if (page != 0) {
            int offset = (page - 1) * 5;
            PageHelper.offsetPage(offset, 5);
        }
        List<Order> orderList = orderService.getOrderByUserId(userId, status);
        if (orderList == null || orderList.size() == 0) {
            //kk
            return new JsonResponse<>(401, "该用户没有订单");
        }
        return new JsonResponse<>(200, Constant.SUCCESS, orderList);
    }

    @RequestMapping(value = "/orderNow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<Void> orderNow(Order order) {
        if (order == null) {
            return new JsonResponse<>(400, "订单错误");
        }
        order.setOrderNo(OrderNoUtil.createOrderNo());
        int orderNow = orderService.orderNow(order);
        System.out.println("orderNow" + orderNow);
        if (orderNow > 0) {
            return new JsonResponse<>(200, "下单成功");
        }
        return new JsonResponse<>(400, "订单错误");
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<Void> updateOrder(Order order) {
        if (order == null) {
            return new JsonResponse<>(400, "订单错误");
        }
        int updateOrder = orderService.updateOrder(order);
        System.out.println("orderNow" + updateOrder);
        if (updateOrder > 0) {
            return new JsonResponse<>(200, "修改成功");
        }
        return new JsonResponse<>(400, "订单错误");
    }
}


