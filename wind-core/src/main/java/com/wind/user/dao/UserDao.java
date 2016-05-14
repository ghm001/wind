package com.wind.user.dao;

import com.wind.user.model.UserVO;

import com.wind.utils.annotation.mybatis.MyBatisScan;

/**
 * 为了想要的、我才一直在战斗。
 * Created by qiuYong on 2015/12/21.
 */
@MyBatisScan
public interface UserDao {
    UserVO getUserInfo(String userName);

    void saveUserInfo(UserVO userVO);

    void addUserIcon(UserVO userVO);

    void updateUserInfo(UserVO userVO);

}
