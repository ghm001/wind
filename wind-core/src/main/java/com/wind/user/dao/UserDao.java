package com.wind.user.dao;

import com.wind.user.model.UserVO;

import com.wind.utils.annotation.mybatis.MyBatisScan;

/**
 * Created by Administrator on 2015/12/21.
 */
@MyBatisScan
public interface UserDao {
    UserVO getUserInfo(String userName);

    void saveUserInfo(UserVO userVO);
}
