package com.wind.carMessage.service;

import com.wind.carMessage.model.BrandVO;
import com.wind.carMessage.model.CarInfoVO;
import com.wind.carMessage.model.WeiZhangInfoVO;
import com.wind.carMessage.model.ZnwhInfoVO;

import java.util.List;

/**
 * Created by Administrator on 2016/4/30.
 */

public interface CarMessageService {
    //获得车品牌信息
   List<BrandVO>  getCarBrandInfo();

    //获得绑定的所有车辆信息
    List<CarInfoVO> getAllCarInfo(int userId);

    //增加一个车辆信息
    void addCarInfo(CarInfoVO carInfoVO);

    //更新一个车辆信息
    void updateCarInfo(CarInfoVO carInfoVO);

    //删除一个车辆信息
    void deleteCarInfo(int carInfoId);

    //清空状态
    void clearState();

    //获得智能维护相关的车辆的信息
    ZnwhInfoVO getZnwhInfo(int userId);

    //更新智能维护相关数据
    void updateZnwhInfo(ZnwhInfoVO znwhInfoVO);

    //查询用户是否存在
    ZnwhInfoVO quryUser(int userId);

    //获取违章相关的车辆信息
    WeiZhangInfoVO getWeiZhangInfo(int userId);

}
