package com.wind.user.service;

import com.wind.user.dao.UserDao;
import com.wind.user.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 为了想要的、我才一直在战斗。
 * Created by qiuYong on 2015/12/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao  userDao;
    @Override
    public UserVO getUserInfo(String userName) {
        return userDao.getUserInfo(userName);
    }

    @Override
    public void saveUserInfo(UserVO userVO) {
        userDao.saveUserInfo(userVO);
    }

    @Override
    public void addUserIcon(UserVO userVO) {
     userDao.addUserIcon(userVO);
    }

    @Override
    public void updateUserInfo(UserVO userVO) {
        userDao.updateUserInfo(userVO);
    }


}
