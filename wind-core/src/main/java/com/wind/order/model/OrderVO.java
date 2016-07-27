package com.wind.order.model;

import java.util.Date;

/**
 * 所有的悲伤都由自己去承担。
 * 努力永远都不会错。
 * Created by Qiuyong on 2016/5/3.
 */

/**
 * 与订单相关的实体类
 */
public class OrderVO {
    private int orderId;//订单id号
    private int orderState;//订单状态
    private String cusName;//顾客姓名
    private String cusPhoneNum;//顾客手机号码
    private String cusPlateNum;//顾客车牌号
    private String gasStationName;//加油站名称
    private String gasStationAddress;//加油站地址
    private String gasType;//汽油类型
    private Double gasLitre;//汽油升数
    private double gasSinglePrice;//没升汽油的价格
    private double gasSumPrice;//总共加油的钱
    private Date orderTime;//预订订单时间
    private String strTime;//预约订单
    private int userId;//指定用户id号

    public OrderVO() {
    }

    public OrderVO(int orderState, String cusName, String cusPhoneNum, String cusPlateNum, String gasStationName, String gasStationAddress, String gasType, double gasLitre, double gasSinglePrice, double gasSumPrice, Date orderTime, int userId) {
        this.orderState = orderState;
        this.cusName = cusName;
        this.cusPhoneNum = cusPhoneNum;
        this.cusPlateNum = cusPlateNum;
        this.gasStationName = gasStationName;
        this.gasStationAddress = gasStationAddress;
        this.gasType = gasType;
        this.gasLitre = gasLitre;
        this.gasSinglePrice = gasSinglePrice;
        this.gasSumPrice = gasSumPrice;
        this.orderTime = orderTime;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhoneNum() {
        return cusPhoneNum;
    }

    public void setCusPhoneNum(String cusPhoneNum) {
        this.cusPhoneNum = cusPhoneNum;
    }

    public String getCusPlateNum() {
        return cusPlateNum;
    }

    public void setCusPlateNum(String cusPlateNum) {
        this.cusPlateNum = cusPlateNum;
    }

    public String getGasStationName() {
        return gasStationName;
    }

    public void setGasStationName(String gasStationName) {
        this.gasStationName = gasStationName;
    }

    public String getGasStationAddress() {
        return gasStationAddress;
    }

    public void setGasStationAddress(String gasStationAddress) {
        this.gasStationAddress = gasStationAddress;
    }

    public Double getGasLitre() {
        return gasLitre;
    }

    public void setGasLitre(Double gasLitre) {
        this.gasLitre = gasLitre;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public double getGasSinglePrice() {
        return gasSinglePrice;
    }

    public void setGasSinglePrice(double gasSinglePrice) {
        this.gasSinglePrice = gasSinglePrice;
    }

    public double getGasSumPrice() {
        return gasSumPrice;
    }

    public void setGasSumPrice(double gasSumPrice) {
        this.gasSumPrice = gasSumPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }


}
