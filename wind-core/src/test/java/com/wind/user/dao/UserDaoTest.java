package com.wind.user.dao;

import com.wind.user.model.UserVO;
import com.wind.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class UserDaoTest {

    @Autowired
    UserService userService;

    //测试用户密码
    @Test
   public void testGetUserInfo( ) {
    UserVO userVO;
         String userName="13166837709";
    userVO=userService.getUserInfo(userName);
        System.out.println(userVO.getUserPass());

    }
}