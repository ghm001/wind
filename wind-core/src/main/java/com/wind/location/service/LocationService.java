package com.wind.location.service;

import com.wind.location.model.UserLocationVO;

import java.util.List;

/**
 * @author qiuyong
 * 调用有关用户的服务层的接口
 */
public interface LocationService {
    //保存用户的位置信息
    public void saveUserLocation(UserLocationVO userLocationVO);

    //删除用户位置信息
    public  void deleteUserLocation(int userId);

    //更新用户位置信息
    public void updateUserLocation(UserLocationVO userLocationVO);

    //查询指定用户有没有存储信息
    public UserLocationVO findUserLocationByUserId(int userId);

    //获取所有的用户的位置
    public List<UserLocationVO> findAllUserLocation();
}
