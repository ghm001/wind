package com.wind.user.dao;

import com.wind.user.model.UserVO;

import com.wind.utils.annotation.mybatis.MyBatisScan;

/**
 * 为了想要的、我才一直在战斗。
 * Created by qiuYong on 2015/12/21.
 */
@MyBatisScan
public interface UserDao {
    //获得用户信息-校验用户登录并且显示用户信息
    public UserVO getUserInfo(String userName);

    //获取用户信息
    public UserVO findUserInfoById(int userId);

    //注册用户-利用手机号与密码（通过短信注册）
    public void saveUserInfo(UserVO userVO);

    //添加用户头像
    public void addUserIcon(UserVO userVO);

    //修用户信息
    public void updateUserInfo(UserVO userVO);

    //修改用户密码
    public void updateUserPass(UserVO userVO);

    //修改登陆状态
    public void updateLoginFlagByUserId(UserVO userVO);

}
