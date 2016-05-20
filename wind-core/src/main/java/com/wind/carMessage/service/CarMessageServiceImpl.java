package com.wind.carMessage.service;

import com.wind.carMessage.dao.CarMessageDao;
import com.wind.carMessage.model.BrandVO;
import com.wind.carMessage.model.CarInfoVO;
import com.wind.carMessage.model.WeiZhangInfoVO;
import com.wind.carMessage.model.ZnwhInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  生活就是枯燥的。
 * Created by qiuYong on 2016/4/30.
 */
@Service
public class CarMessageServiceImpl implements CarMessageService{
    @Autowired
    CarMessageDao carMessageDao;

    @Override
    public List<BrandVO> getCarBrandInfo() {
        return carMessageDao.getCarBrandInfo();
    }

    @Override
    public List<CarInfoVO> getAllCarInfo() {
        return carMessageDao.getAllCarInfo();
    }

    @Override
    public void addCarInfo(CarInfoVO carInfoVO) {
       carMessageDao.addCarInfo(carInfoVO);
    }

    @Override
    public void updateCarInfo(CarInfoVO carInfoVO) {
        carMessageDao.updateCarInfo(carInfoVO);
    }

    @Override
    public void deleteCarInfo(int carInfoId) {
        carMessageDao.deleteCarInfo(carInfoId);
    }

    @Override
    public void clearState() {
        carMessageDao.clearState();
    }

    @Override
    public ZnwhInfoVO getZnwhInfo(int userId) {
        return carMessageDao.getZnwhInfo(userId);
    }

    @Override
    public void updateZnwhInfo(ZnwhInfoVO znwhInfoVO) {
        carMessageDao.updateZnwhInfo(znwhInfoVO);
    }

    @Override
    public ZnwhInfoVO quryUser(int userId) {
        return  carMessageDao.quryUser(userId);
    }

    @Override
    public WeiZhangInfoVO getWeiZhangInfo(int userId) {
        return carMessageDao.getWeiZhangInfo(userId);
    }


}
