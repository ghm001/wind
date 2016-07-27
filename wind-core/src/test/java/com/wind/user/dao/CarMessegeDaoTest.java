package com.wind.user.dao;

import com.wind.carMessage.model.*;
import com.wind.carMessage.service.CarMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 不仅要长得风骚，写代码我依然风骚。
 * Created by qiuYong on 2016/4/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class CarMessegeDaoTest {
    @Autowired
    CarMessageService carMessageService;

    //测试获得车品牌相关信息
    @Test
    public void getCarBrandInfo() {
        List<BrandVO> list = new ArrayList<BrandVO>();
        list = carMessageService.getCarBrandInfo();
        System.out.println("该应用支持的车品牌标志总量:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            List<BrandTypeVO> brand = list.get(i).getBrandTypeList();
            System.out.print((i + 1) + ":" + "品牌：" + list.get(i).getBrand() + "----" + "品牌标志:" + list.get(i).getCarFlag() + "---");
            System.out.println("详细类型" + brand.get(0).getName() + " ");
        }
    }

    //获得指定用户获得的所有已经添加的车辆信息
    @Test
    public void getAllCarInfo() {
        int userId = 1;//指定对应用户
        List<CarInfoVO> list = new ArrayList<CarInfoVO>();
        list = carMessageService.getAllCarInfo(1);

        System.out.print("真实姓名:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getName() + "-");
            } else {
                System.out.println(list.get(i).getName());
            }
        }

        System.out.print("手机号码:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getPhoneNum() + "-");
            } else {
                System.out.println(list.get(i).getPhoneNum());
            }
        }

        System.out.print("品牌索引:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getBrandIndex() + "-");
            } else {
                System.out.println(list.get(i).getBrandIndex());
            }
        }

        System.out.print("具体类型索引:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getBrandTypeIndex() + "-");
            } else {
                System.out.println(list.get(i).getBrandTypeIndex());
            }
        }

        System.out.print("车标志图片:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getCarFlag() + "-");
            } else {
                System.out.println(list.get(i).getCarFlag());
            }
        }

        System.out.print("车牌省份索引:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getProvinceIndex() + "-");
            } else {
                System.out.println(list.get(i).getProvinceIndex());
            }
        }

        System.out.print("座位数:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getSeatCount() + "-");
            } else {
                System.out.println(list.get(i).getSeatCount());
            }
        }

        System.out.print("门数:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getDoorCount() + "-");
            } else {
                System.out.println(list.get(i).getDoorCount());
            }
        }


        System.out.print("车牌尾号:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getCarLicenceTail() + "-");
            } else {
                System.out.println(list.get(i).getCarLicenceTail());
            }
        }

        System.out.print("车架号:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getChassisNum() + "-");
            } else {
                System.out.println(list.get(i).getChassisNum());
            }
        }

        System.out.print("引擎号:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getEngineNum() + "-");
            } else {
                System.out.println(list.get(i).getEngineNum());
            }
        }

        System.out.print("行驶公里数:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getMileage() + "-");
            } else {
                System.out.println(list.get(i).getMileage());
            }
        }

        System.out.print("剩余油量:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getOddGasAmount() + "-");
            } else {
                System.out.println(list.get(i).getOddGasAmount());
            }
        }

        System.out.print("车灯:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getIsGoodLight() + "-");
            } else {
                System.out.println(list.get(i).getIsGoodLight());
            }
        }

        System.out.print("引擎:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getIsGoodEngine() + "-");
            } else {
                System.out.println(list.get(i).getIsGoodEngine());
            }
        }

        System.out.print("变速器:");
        for (int i = 0; i < list.size(); i++) {
            if (i != 2) {
                System.out.print(list.get(i).getIsGoodTran() + "-");
            } else {
                System.out.println(list.get(i).getIsGoodTran());
            }
        }
    }

    //为指定用户添加一个车辆信息
    @Test
    public void addCarInfo() {
        CarInfoVO carInfoVO = new CarInfoVO();
        carInfoVO.setBrandIndex(5);//车牌索引
        carInfoVO.setBrandTypeIndex(1);//车牌类型索引
        carInfoVO.setCarLicenceTail("111");//车牌尾号
        carInfoVO.setDoorCount(5);
        carInfoVO.setSeatCount(3);
        carInfoVO.setCarFlag("mini.png");
        carInfoVO.setProvinceIndex(1);
        carInfoVO.setChassisNum("123456");
        carInfoVO.setCarLicenceTail("A12345");
        carInfoVO.setPhoneNum("13166837709");
        carInfoVO.setMileage(11100);
        carInfoVO.setOddGasAmount(95);
        carInfoVO.setIsGoodEngine(1);
        carInfoVO.setIsGoodLight(0);
        carInfoVO.setIsGoodTran(1);
        carInfoVO.setState(1);
        carInfoVO.setUserId(1);
        carMessageService.addCarInfo(carInfoVO);
    }

    //修改指定的车辆信息
    @Test
    public void updateCarInfo() {
        CarInfoVO carInfoVO = new CarInfoVO();
        carInfoVO.setCarInfoId(5);
        carInfoVO.setBrandIndex(1);
        carInfoVO.setBrandTypeIndex(1);
        carInfoVO.setCarFlag("111111");
        carInfoVO.setProvinceIndex(1);
        carInfoVO.setSeatCount(1);
        carInfoVO.setDoorCount(1);
        carInfoVO.setChassisNum("11111");
        carInfoVO.setEngineNum("11111");
        carInfoVO.setCarLicenceTail("");
        carInfoVO.setName("");
        carInfoVO.setPhoneNum("11011011911");
        carInfoVO.setMileage(1);
        carInfoVO.setOddGasAmount(50);
        carInfoVO.setIsGoodEngine(1);
        carInfoVO.setIsGoodTran(1);
        carInfoVO.setIsGoodLight(0);
        carInfoVO.setState(1);
        carMessageService.updateCarInfo(carInfoVO);
    }

    //删除指定的车辆信息
    @Test
    public void deleteCarInfo() {
        int carInfoId = 6;
        carMessageService.deleteCarInfo(carInfoId);
    }


    //获得指定用户的相关的异常提醒相关数据
    @Test
    public void getZnwhInfo() {
        int userId = 1;
        System.out.println("说明:1代表正常|0代表异常");
        ZnwhInfoVO znwhInfoVO = carMessageService.getZnwhInfo(userId);
        System.out.println("行驶公里数：" + znwhInfoVO.getMileage());
        System.out.println("剩余汽油量:" + znwhInfoVO.getOddGasAmount());
        System.out.println("车灯状况：:" + znwhInfoVO.getIsGoodLight());
        System.out.println("变速器状况:" + znwhInfoVO.getIsGoodTran());
        System.out.println("引擎:" + znwhInfoVO.getIsGoodEngine());
    }

    /*
     动态修改智能维护相关信息（行驶公里数、剩余油量、车灯、变速器、引擎）
     通知条件自定义规则（每隔10s刷新一次数据）：
     行驶公里数：每次增加的公里数为1-100中的随机数
     剩余汽油量：生成1-100的随机数
     车灯状况：如果随机数大于0.95，则车灯异常，反之正常。
     变速器状况：如果随机数大于0.95，则车灯异常，反之正常。
     引擎状况：如果随机数大于0.95，则车灯异常，反之正常。
      */
    @Test
    public void updateZnwhInfo() {
        ZnwhInfoVO znwhInfoVO = new ZnwhInfoVO();
        znwhInfoVO.setUserId(1);
        znwhInfoVO.setIsGoodEngine(1);
        znwhInfoVO.setIsGoodLight(1);
        znwhInfoVO.setIsGoodTran(1);
        znwhInfoVO.setMileage(150000);
        znwhInfoVO.setOddGasAmount(50);
        carMessageService.updateZnwhInfo(znwhInfoVO);
    }

    //查询指定用户是否含有默认车辆
    @Test
    public void quetyMrcl() {
        int userId = 1;
        System.out.println("该用户的id号为：" + userId);
        ZnwhInfoVO znwhInfoVO = carMessageService.getZnwhInfo(userId);
        if (znwhInfoVO == null) {
            System.out.println("该用户不存在默认车辆");
        } else {
            System.out.println("该用户存在默认车辆");
        }

        int userId1 = 5;
        System.out.println("该用户的id号为：" + userId1);
        ZnwhInfoVO znwhInfoVO1 = carMessageService.getZnwhInfo(userId1);
        if (znwhInfoVO1 == null) {
            System.out.println("该用户不存在默认车辆");
        } else {
            System.out.println("该用户存在默认车辆");
        }
    }

    //如果该用户含有默认车辆，即可获取违章信息相关数据
    @Test
    public void getWeiZhangInfo() {
        int userId = 1;
        WeiZhangInfoVO weiZhangInfoVO;
        weiZhangInfoVO = carMessageService.getWeiZhangInfo(userId);
        System.out.println("车主姓名：" + weiZhangInfoVO.getName());
        System.out.println("车牌索引：" + weiZhangInfoVO.getProvinceIndex());
        System.out.println("车牌尾号：" + weiZhangInfoVO.getCarLicenceTail());
        System.out.println("引擎号：" + weiZhangInfoVO.getEngineNum());
        System.out.println("车架号：" + weiZhangInfoVO.getChassisNum());
    }


}
