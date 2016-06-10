package com.wind.carMessage.model;

/**
 * 所有的悲伤都由自己去承担。
 * 努力永远都不会错。
 * Created by Qiuyong on 2016/5/3.
 */

/**
 * 某车品牌拥有的所有具体的车型号
 */
public class BrandTypeVO {
    private String name;//具体车牌类型名称

    public BrandTypeVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandTypeVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
