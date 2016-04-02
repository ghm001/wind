package com.wind.user.model;

/**
 * Created by Administrator on 2016/3/8.
 */
public class UserVO {
    private int userId;
    private String password;
    private  String userName;
    private  int roleId;
    private int salesmanId;

    public UserVO() {
    }

    public UserVO(int userId, String password, String userName, int roleId, int salesmanId) {

        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.roleId = roleId;
        this.salesmanId = salesmanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", roleId=" + roleId +
                ", salesmanId=" + salesmanId +
                '}';
    }
}
