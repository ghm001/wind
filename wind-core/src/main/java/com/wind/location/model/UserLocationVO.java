package com.wind.location.model;

/**
 * @author qiuyong
 * 用于描述用户位置的实体类
 */
public class UserLocationVO {
    private int userLocationId;//用户所处位置Id号
    private int userId;//用户的Id号
    private double userLat;//用户所处纬度
    private double userLng;//用户所处经度
    private String userAddress;//用户所处的详细地址

    public UserLocationVO() {
    }

    public UserLocationVO(int userId, double userLat, double userLng, String userAddress) {
        this.userId = userId;
        this.userLat = userLat;
        this.userLng = userLng;
        this.userAddress = userAddress;
    }

    public int getUserLocationId() {
        return userLocationId;
    }

    public void setUserLocationId(int userLocationId) {
        this.userLocationId = userLocationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getUserLat() {
        return userLat;
    }

    public void setUserLat(double userLat) {
        this.userLat = userLat;
    }

    public double getUserLng() {
        return userLng;
    }

    public void setUserLng(double userLng) {
        this.userLng = userLng;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
