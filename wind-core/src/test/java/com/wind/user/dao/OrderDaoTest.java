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


    //添加一个订单
    @Test
    public void addOrderInfo() {
        OrderVO orderVO = new OrderVO();
        orderVO.setCusName("戴维斯.刘娜娜");//车主姓名
        Date date = new Date();
        orderVO.setOrderTime(date);//预定时间
        orderVO.setOrderState(0);
        orderVO.setCusPhoneNum("13166837709");
        orderVO.setCusPlateNum("湘A12345");
        orderVO.setUserId(2);
        orderVO.setGasStationName("长春土豪金加油站");
        orderVO.setGasStationAddress("吉林省长春市芭芭拉路");
        orderVO.setGasType("-20#");//汽油类型
        orderVO.setGasLitre(5.0);//升数
        orderVO.setGasSinglePrice(5.5);//每升的单价
        orderVO.setGasSumPrice(27.5);//总价
        orderVO.setUserId(3);//用户id号
        orderService.addOrderInfo(orderVO);
    }

    //查询所有订单(包含未支付 已支付 已加油)
    @Test
    public void getOrderInfos() {
        List<OrderVO> list = new ArrayList<OrderVO>();
        list = orderService.getOrderInfos(1);
        System.out.println(list.get(0).getCusName());
    }

    //取消某个订单
    @Test
    public void deleteOrderInfo() {
        int orderId = 40;
        orderService.deleteOrderInfo(orderId);
    }

    //改变订单状态
    void changeOrderState() {
        int orderId = 41;
        orderService.changeOrderState(orderId);
    }

    //获取指定用户的未支付订单
    @Test
    public void getWzfOrderInfos() {
        int userId = 1;
        List<OrderVO> list = new ArrayList<OrderVO>();
        list = orderService.getWzfOrderInfos(userId);
        System.out.println(list.get(0).getCusName());
    }

    //获取指定用户的已支付订单
    @Test
    public void getYzfOrderInfos() {
        int userId = 1;
        List<OrderVO> list = new ArrayList<OrderVO>();
        list = orderService.getYzfOrderInfos(userId);
        System.out.println(list.get(0).getCusName());
    }
}
