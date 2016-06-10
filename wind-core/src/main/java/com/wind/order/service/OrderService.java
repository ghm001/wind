package com.wind.order.service;

import com.wind.order.model.OrderVO;

import java.util.List;

/**
 * Created by Administrator on 2016/5/2.
 */
public interface OrderService  {
    //添加一个订单
    void addOrderInfo(OrderVO orderVO);

    //查询订单里面的信息
    List<OrderVO> getOrderInfos(int userId);

    //取消某个订单
    void deleteOrderInfo(int orderId);

    //改变订单状态
    void changeOrderState(int orderId);

    //查询未支付订单的信息
    List<OrderVO> getWzfOrderInfos(int userId);

    //查询已支付订单信息
    List<OrderVO> getYzfOrderInfos(int userId);
}
