package com.wind.user.service;

import com.wind.user.dao.UserDao;
import com.wind.user.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao  userDao;
    @Override
    public UserVO getUserInfo(String userId) {
        return userDao.getUserInfo(userId);
    }

}
