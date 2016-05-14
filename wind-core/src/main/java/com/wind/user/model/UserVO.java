package com.wind.user.model;

/**
 * 为了想要的、我才一直在战斗。
 * Created by qiuYong on 2016/3/8.
 */
public class UserVO {
    private  String userName;//用户名
    private String userPass;//用户密码
    private  String nickname;//昵称
    private String sex;//性别
    private int age;//年龄
    private String driverNum;//驾驶证号
    private Object userIconContent;//图片的字符串
    private  String message;//登录验证

    public UserVO() {
    }

    public Object getUserIconContent() {
        return userIconContent;
    }

    public void setUserIconContent(Object userIconContent) {
        this.userIconContent = userIconContent;
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


}
