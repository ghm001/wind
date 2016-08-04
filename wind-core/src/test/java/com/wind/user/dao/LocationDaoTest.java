package com.wind.user.dao;

import com.wind.location.model.UserLocationVO;
import com.wind.location.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class LocationDaoTest {
    @Autowired
    LocationService locationService;

    @Test
    public void saveUserLocation(){
        String address="hello";
        UserLocationVO locationVO=new UserLocationVO();
        locationVO.setUserAddress(address);
        locationService.saveUserLocation(locationVO);
    }

    @Test
    public void deleteUserLocation(){
        locationService.deleteUserLocation(2);
    }

    @Test
    public void findUserLocation(){
        UserLocationVO userLocationVO=locationService.findUserLocationByUserId(0);
        if(null!=userLocationVO){
            System.out.println(userLocationVO.getUserId());
            System.out.println(userLocationVO.getUserAddress());
        }

    }
}
