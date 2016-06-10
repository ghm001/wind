package com.wind.carMessage.model;

/**
 * 所有的悲伤都由自己去承担。
 * 努力永远都不会错。
 * Created by Qiuyong on 2016/5/3.
 */

/**
 * 指定用户的车辆信息
 */
public class CarInfoVO {
    private int userId;//用户id
    private int carInfoId;//车辆信息id

    private int brandIndex;//车型号索引；
    private int brandTypeIndex;//车类型索引
    private String carFlag;//车标志图片

    private int provinceIndex;//车牌省份索引
    private String carLicenceTail;//车牌尾号

    private int seatCount;//座位号的数量
    private int doorCount;//门的数量
    private String chassisNum;//车架号
    private String engineNum;//引擎号

    private String name;//车主姓名
    private String phoneNum;//车主手机号码

    private double mileage;//所行驶的公里数
    private int oddGasAmount;//剩余的汽油百分比
    private int isGoodEngine;//引擎状况
    private int isGoodTran;//变速器状况
    private int isGoodLight;//车灯状况

    private int state;//车状态-默认车辆还是其他

    public CarInfoVO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(int carInfoId) {
        this.carInfoId = carInfoId;
    }

    public int getBrandIndex() {
        return brandIndex;
    }

    public void setBrandIndex(int brandIndex) {
        this.brandIndex = brandIndex;
    }

    public int getBrandTypeIndex() {
        return brandTypeIndex;
    }

    public void setBrandTypeIndex(int brandTypeIndex) {
        this.brandTypeIndex = brandTypeIndex;
    }

    public String getCarFlag() {
        return carFlag;
    }

    public void setCarFlag(String carFlag) {
        this.carFlag = carFlag;
    }

    public int getProvinceIndex() {
        return provinceIndex;
    }

    public void setProvinceIndex(int provinceIndex) {
        this.provinceIndex = provinceIndex;
    }

    public String getCarLicenceTail() {
        return carLicenceTail;
    }

    public void setCarLicenceTail(String carLicenceTail) {
        this.carLicenceTail = carLicenceTail;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public String getChassisNum() {
        return chassisNum;
    }

    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getOddGasAmount() {
        return oddGasAmount;
    }

    public void setOddGasAmount(int oddGasAmount) {
        this.oddGasAmount = oddGasAmount;
    }

    public int getIsGoodEngine() {
        return isGoodEngine;
    }

    public void setIsGoodEngine(int isGoodEngine) {
        this.isGoodEngine = isGoodEngine;
    }

    public int getIsGoodTran() {
        return isGoodTran;
    }

    public void setIsGoodTran(int isGoodTran) {
        this.isGoodTran = isGoodTran;
    }

    public int getIsGoodLight() {
        return isGoodLight;
    }

    public void setIsGoodLight(int isGoodLight) {
        this.isGoodLight = isGoodLight;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CarInfoVO{" +
                "carInfoId=" + carInfoId +
                ", brandIndex=" + brandIndex +
                ", brandTypeIndex=" + brandTypeIndex +
                ", carFlag='" + carFlag + '\'' +
                ", provinceIndex=" + provinceIndex +
                ", carLicenceTail='" + carLicenceTail + '\'' +
                ", seatCount=" + seatCount +
                ", doorCount=" + doorCount +
                ", chassisNum='" + chassisNum + '\'' +
                ", engineNum='" + engineNum + '\'' +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", mileage=" + mileage +
                ", oddGasAmount=" + oddGasAmount +
                ", isGoodEngine=" + isGoodEngine +
                ", isGoodTran=" + isGoodTran +
                ", isGoodLight=" + isGoodLight +
                ", state=" + state +
                '}';
    }
}
