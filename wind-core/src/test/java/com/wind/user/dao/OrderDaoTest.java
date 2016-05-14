package com.wind.user.dao;

import com.wind.order.model.OrderVO;
import com.wind.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class OrderDaoTest {
    @Autowired
    OrderService orderService;

    @Test
        public void addOrderInfo(){
        OrderVO orderVO=new OrderVO();
        orderVO.setCusName("黄大炮");
        Date date=new Date();
        orderVO.setOrderTime(date);
        orderService.addOrderInfo(orderVO);
        }
    @Test
    public void getOrderInfos(){
        List<OrderVO>  list=new ArrayList<OrderVO>();
        list=orderService.getOrderInfos();
        System.out.println(list.get(0).getCusName());
    }

    @Test
    public void deleteOrderInfo(){
        int orderId=1;
        orderService.deleteOrderInfo(orderId);
    }

    @Test
    public void changeOrderState(){
        int orderId=2;
        orderService.changeOrderState(orderId);
    }
}
