package com.wind.user.model;

/**
 * Created by Administrator on 2016/3/8.
 */
public class UserVO {
    private  String userName;//用户名
    private String userPass;//用户密码
    private  String nickname;//昵称
    private String sex;//性别
    private String age;//年龄
    private String driverNum;//驾驶证号
    private  String message;//登录验证

    public UserVO() {
    }

    public UserVO(String userName, String userPass, String nickname, String sex, String age, String driverNum, String message) {
        this.userName = userName;
        this.userPass = userPass;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.driverNum = driverNum;
        this.message = message;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
                ", age='" + age + '\'' +
                ", driverNum='" + driverNum + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
