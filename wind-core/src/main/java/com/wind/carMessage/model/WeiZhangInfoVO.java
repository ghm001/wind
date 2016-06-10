package com.wind.carMessage.model;

/**
 * 所有的悲伤都由自己去承担。
 * 努力永远都不会错。
 * Created by Qiuyong on 2016/5/3.
 */

/**
 * 默认车辆违章信息的实体类
 */
public class WeiZhangInfoVO {
    private String name;//车主姓名
    private int provinceIndex;//车牌索引
    private String carLicenceTail;//车牌尾号
    private String engineNum;//引擎号
    private String chassisNum;//车架号

    public WeiZhangInfoVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public String getCarLicenceTail() {
        return carLicenceTail;
    }

    public void setCarLicenceTail(String carLicenceTail) {
        this.carLicenceTail = carLicenceTail;
    }

    public int getProvinceIndex() {
        return provinceIndex;
    }

    public void setProvinceIndex(int provinceIndex) {
        this.provinceIndex = provinceIndex;
    }

    public String getChassisNum() {
        return chassisNum;
    }

    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }

    @Override
    public String toString() {
        return "WeiZhangInfoVO{" +
                "name='" + name + '\'' +
                ", provinceIndex=" + provinceIndex +
                ", carLicenceTail='" + carLicenceTail + '\'' +
                ", engineNum='" + engineNum + '\'' +
                ", chassisNum='" + chassisNum + '\'' +
                '}';
    }
}
