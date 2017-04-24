package com.wind.location.service;

import com.wind.location.dao.LocationDao;
import com.wind.location.model.UserLocationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuyong
 * 调用有关用户的服务层的实现
 */
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationDao locationDao;
    @Override
    public void saveUserLocation(UserLocationVO userLocationVO) {
        this.locationDao.saveUserLocation(userLocationVO);
    }

    @Override
    public void deleteUserLocation(int userId) {
        locationDao.deleteUserLocation(userId);
    }

    @Override
    public void updateUserLocation(UserLocationVO userLocationVO) {
        locationDao.updateUserLocation(userLocationVO);
    }

    @Override
    public UserLocationVO findUserLocationByUserId(int userId) {
        return locationDao.findUserLocationByUserId(userId);
    }


    @Override
    public List<UserLocationVO> findAllUserLocation() {
        return locationDao.findAllUserLocation();
    }
}
