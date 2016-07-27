package com.wind.order;


import com.wind.order.model.OrderVO;
import com.wind.order.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/3.
 */
@Controller
public class OrderController {
    @Autowired
    private  OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/Order/AddOrderInfo",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public void addOrderInfo(HttpServletRequest request){
        int orderState=0;
        int userId=Integer.parseInt(request.getParameter("userId"));
        String cusName=request.getParameter("cusName");
        System.out.println(cusName);
        String cusPhoneNum=request.getParameter("cusPhoneNum");
        String cusPlateNum=request.getParameter("cusPlateNum");
        String gasStationName=request.getParameter("gasStationName");
        String gasStationAddress=request.getParameter("gasStationAddress");
        String gasType=request.getParameter("gasType");
        Double gasLitre=Double.parseDouble(request.getParameter("gasLitre"));
        double gasSinglePrice=Double.parseDouble(request.getParameter("gasSinglePrice").trim());
        double gasSumPrice=Double.parseDouble(request.getParameter("gasSumPrice").trim());
        Date orderTime=new Date();
        OrderVO orderVO=new OrderVO(orderState,cusName,cusPhoneNum,cusPlateNum,gasStationName,gasStationAddress,gasType,gasLitre,gasSinglePrice,gasSumPrice,orderTime,userId);
       orderService.addOrderInfo(orderVO);
    }

    @ResponseBody
      @RequestMapping(value = "/Order/GetOrderInfos",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
      public String getOrderInfos(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        List<OrderVO> list=new ArrayList<OrderVO>();
        list=orderService.getOrderInfos(userId);
        for (int i=0;i<list.size();i++){
            Date date=list.get(i).getOrderTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            list.get(i).setStrTime(format.format(date));
        }
        String json=new JSONArray().fromObject(list).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Order/GetWzfOrderInfos",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getWzfOrderInfos(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        List<OrderVO> list=new ArrayList<OrderVO>();
        list=orderService.getWzfOrderInfos(userId);
        
        for (int i=0;i<list.size();i++){
            Date date=list.get(i).getOrderTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            list.get(i).setStrTime(format.format(date));
        }
        String json=new JSONArray().fromObject(list).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Order/GetYzfOrderInfos",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getYzfOrderInfos(HttpServletRequest request){
      int userId=Integer.parseInt(request.getParameter("userId"));
        List<OrderVO> list=new ArrayList<OrderVO>();
        list=orderService.getYzfOrderInfos(userId);
        for (int i=0;i<list.size();i++){
            Date date=list.get(i).getOrderTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            list.get(i).setStrTime(format.format(date));
        }
        String json=new JSONArray().fromObject(list).toString();
        return json;
    }

    @ResponseBody
       @RequestMapping(value = "/Order/DeleteOrderInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
       public void deleteOrderInfo(HttpServletRequest request){
        int orderId=Integer.parseInt(request.getParameter("orderId"));
        orderService.deleteOrderInfo(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/Order/ChangeOrderState",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public void changeOrderState(HttpServletRequest request){
        int orderId=Integer.parseInt(request.getParameter("orderId"));
        orderService.changeOrderState(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/Order/DeleteHopedOrderInfo",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public void deleteHopedCarInfo(HttpServletRequest request){
        String str=  request.getParameter("json");
        System.out.println(str);
        JSONArray jsonArray=new JSONArray().fromObject(str);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject= (JSONObject) jsonArray.get(i);
            int orderInfo=Integer.parseInt(jsonObject.getString("value"));
            System.out.println(orderInfo+"");
            orderService.deleteOrderInfo(orderInfo);
        }
    }

}
