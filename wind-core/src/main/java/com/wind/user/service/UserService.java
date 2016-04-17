package com.wind.user.service;

import com.wind.user.model.UserVO;

/**
 * Created by Administrator on 2015/12/21.
 */
public interface UserService {
    //获取用户信息---并且登录
    UserVO getUserInfo(String userName);

    //注册用户
    void saveUserInfo(UserVO userVO);

}
