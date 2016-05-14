package com.wind.user.dao;

import com.wind.carMessage.model.BrandTypeVO;
import com.wind.carMessage.model.BrandVO;
import com.wind.carMessage.model.CarInfoVO;
import com.wind.carMessage.model.ZnwhInfoVO;
import com.wind.carMessage.service.CarMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 *    不仅要长得风骚，写代码我依然风骚。
 * Created by qiuYong on 2016/4/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class CarMessegeDaoTest {
    @Autowired
    CarMessageService carMessageService;

    @Test
   public void  getCarBrandInfo(){
       List<BrandVO> list=new ArrayList<BrandVO>();
       list=carMessageService.getCarBrandInfo();
        BrandTypeVO  brandTypeVO=list.get(1).getBrandTypeList().get(0);
        System.out.print(brandTypeVO.getName());
    }

    @Test
    public void getAllCarInfo(){
        List<CarInfoVO> list=new ArrayList<CarInfoVO>();
        list=carMessageService.getAllCarInfo();
        System.out.println(list.get(0).getName());
    }

    @Test
    public void addCarInfo(){
        CarInfoVO carInfoVO=new CarInfoVO();
        carInfoVO.setBrandIndex(5);
        carInfoVO.setCarLicenceTail("111");
        carMessageService.addCarInfo(carInfoVO);
    }

    @Test
    public void updateCarInfo(){
        CarInfoVO carInfoVO=new CarInfoVO();
        carInfoVO.setCarInfoId(40);
        carInfoVO.setBrandIndex(1);
        carInfoVO.setBrandTypeIndex(1);
        carInfoVO.setCarFlag("11");
        carInfoVO.setProvinceIndex(1);
        carInfoVO.setSeatCount(1);
        carInfoVO.setDoorCount(1);
        carInfoVO.setChassisNum("11");
        carInfoVO.setEngineNum("1");
        carInfoVO.setCarLicenceTail("");
        carInfoVO.setName("1");
        carInfoVO.setPhoneNum("");
        carInfoVO.setMileage(1);
        carInfoVO.setOddGasAmount(50);
        carInfoVO.setIsGoodEngine(1);
        carInfoVO.setIsGoodTran(1);
        carInfoVO.setIsGoodLight(0);
        carInfoVO.setState(1);
        carMessageService.updateCarInfo(carInfoVO);
    }

    @Test
    public void deleteCarInfo(){
        int carInfoId=15;
        carMessageService.deleteCarInfo(carInfoId);
    }

    @Test
    public void getZnwhInfo(){
        int userId=1;
        ZnwhInfoVO znwhInfoVO=carMessageService.getZnwhInfo(userId);
        System.out.println(znwhInfoVO.getMileage());
    }

    @Test
    public void updateZnwhInfo(){
        ZnwhInfoVO znwhInfoVO=new ZnwhInfoVO();
        znwhInfoVO.setUserId(1);
        znwhInfoVO.setIsGoodEngine(1);
        znwhInfoVO.setIsGoodLight(1);
        znwhInfoVO.setIsGoodTran(1);
        znwhInfoVO.setMileage(111);
        znwhInfoVO.setOddGasAmount(50);
        carMessageService.updateZnwhInfo(znwhInfoVO);
    }

    @Test
    public void queryZnwhInfo(){
        int userId=1;
        ZnwhInfoVO znwhInfoVO=carMessageService.getZnwhInfo(userId);
        System.out.println(znwhInfoVO.getMileage());
    }


}
