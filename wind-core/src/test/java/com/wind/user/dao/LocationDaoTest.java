package com.wind.user.dao;

import com.wind.location.model.UserLocationVO;
import com.wind.location.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class LocationDaoTest {
    @Autowired
    LocationService locationService;

    @Test
    //每间隔一段时间 后台监听获取用户的经纬度并且保存
    public void saveUserLocation(){
        UserLocationVO locationVO=new UserLocationVO();
        locationVO.setUserId(3);//设置用户id
        locationVO.setUserLng(43.123);//设置用户经度
        locationVO.setUserLat(169.33);//设置用户纬度
        locationService.saveUserLocation(locationVO);
    }

    @Test
    //删除用户的位置信息ByUserId
    public void deleteUserLocation(){
        locationService.deleteUserLocation(3);
    }

    //通过用户id去获取用户id
    @Test
    public void findUserLocation(){
        UserLocationVO userLocationVO=locationService.findUserLocationByUserId(1);
        if(null!=userLocationVO){
            System.out.println("用户locationId:"+userLocationVO.getUserLocationId());
            System.out.println("用户id:"+userLocationVO.getUserId());
            System.out.println("用户纬度:"+userLocationVO.getUserLat());
            System.out.println("用户经度:"+userLocationVO.getUserLng());
        }
    }

    //获取所有的用户位置信息
    @Test
    public void findAllUserLocation(){
        List<UserLocationVO> ls=locationService.findAllUserLocation();
        if(null!=ls&&ls.size()>0){
            for(int i=0;i<ls.size();i++){
                System.out.println("用户locationId:" + ls.get(i).getUserLocationId());
                System.out.println("用户id:" + ls.get(i).getUserId());
                System.out.println("用户纬度:" + ls.get(i).getUserLat());
                System.out.println("用户经度:" + ls.get(i).getUserLng());
                System.out.println("-------------------------------------------");
            }
        }
    }

    @Test
    public void updateUserLocation(){
        UserLocationVO userLocationVO=new UserLocationVO();
        userLocationVO.setUserLat(1.0);
        userLocationVO.setUserLng(2.0);
        userLocationVO.setUserId(1);
        locationService.updateUserLocation(userLocationVO);
    }
}
