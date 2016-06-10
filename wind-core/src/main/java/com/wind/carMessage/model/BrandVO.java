package com.wind.carMessage.model;

import java.util.List;

/**
 * 所有的悲伤都由自己去承担。
 * 努力永远都不会错。
 * Created by Qiuyong on 2016/5/3.
 */

/**
 * 市场上车品牌的相关信息
 */
public class BrandVO {
    private int id;//车品牌的id号
    private String brand;//对应品牌
    private String carFlag;//对应品牌的图片
    private List<BrandTypeVO> brandTypeList;//该车品牌的具体型号

    public BrandVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarFlag() {
        return carFlag;
    }

    public void setCarFlag(String carFlag) {
        this.carFlag = carFlag;
    }

    public List<BrandTypeVO> getBrandTypeList() {
        return brandTypeList;
    }

    public void setBrandTypeList(List<BrandTypeVO> brandTypeList) {
        this.brandTypeList = brandTypeList;
    }

    @Override
    public String toString() {
        return "BrandVO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", carFlag='" + carFlag + '\'' +
                ", brandTypeList=" + brandTypeList +
                '}';
    }
}
