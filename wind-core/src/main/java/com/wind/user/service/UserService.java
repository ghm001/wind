package com.wind.user.service;

import com.wind.user.model.UserVO;

/**
 * 为了想要的、我才一直在战斗。
 * Created by qiuYong on 2015/12/21.
 */
public interface UserService {
    //获取用户信息---并且登录
    UserVO getUserInfo(String userName);

    //注册用户
    void saveUserInfo(UserVO userVO);

    //保存用户头像
    void addUserIcon(UserVO userVO);

    //更新用户信息
    void updateUserInfo(UserVO userVO);

    //修改用户密码
    void updateUserPass(UserVO userVO);

}
