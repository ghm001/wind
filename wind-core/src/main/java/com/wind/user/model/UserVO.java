package com.wind.user.model;

/**
 * 为了想要的、我才一直在战斗。
 * Created by qiuYong on 2016/3/8.
 */

/**
 * 与用户相关的实体类
 */
public class UserVO {
    private int userId;//用户id号
    private String userName;//用户名
    private String userPass;//用户密码
    private String nickname;//昵称
    private String sex;//性别
    private int age;//年龄
    private String driverNum;//驾驶证号
    private String message;//登录验证
    private String userIconUrl;

    public UserVO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", driverNum='" + driverNum + '\'' +
                ", message='" + message + '\'' +
                ", userIconUrl='" + userIconUrl + '\'' +
                '}';
    }
}
