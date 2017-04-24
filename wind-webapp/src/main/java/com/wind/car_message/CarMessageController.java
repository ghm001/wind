package com.wind.car_message;

import com.wind.carMessage.model.*;
import com.wind.carMessage.service.CarMessageService;
import com.wind.common.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2016/4/30.
 */

@Controller
public class CarMessageController {
    @Autowired
    private CarMessageService carMessageService;

    /**
     * @author  Aaron_qiuyong
     * @discription  获取车辆品牌相关信息
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/BrandInfo",method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
    public String getBrandInfoList(){
        List<BrandVO> list=new ArrayList<BrandVO>();
        list=carMessageService.getCarBrandInfo();
        String json=new JSONArray().fromObject(list).toString();
        return json;
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  根据用户id号获取车辆信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/CarInfo",method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
    public String getCarInfoList(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        List<CarInfoVO> list=new ArrayList<CarInfoVO>();
        list=carMessageService.getAllCarInfo(userId);
        String json=new JSONArray().fromObject(list).toString();
        System.out.println("CarInfo:"+json);
        return json;
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  车辆管理_添加车辆信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/AddCarInfo",method = RequestMethod.POST,produces ="text/plain;charset=UTF-8")
    public void addCrInfo(HttpServletRequest request){

        int brandIndex=Integer.parseInt(request.getParameter("brandIndex"));
        int brandTypeIndex=Integer.parseInt(request.getParameter("brandTypeIndex"));
        String carFlag=request.getParameter("carFlag");
        int provinceIndex=Integer.parseInt(request.getParameter("provinceIndex"));
        String carLicenceTail=request.getParameter("carLicenceTail");
        String name=request.getParameter("name");
        String phoneNum=request.getParameter("phoneNum");
        String chassisNum=request.getParameter("chassisNum");
        String engineNum=request.getParameter("engineNum");
        Double mileage=Double.parseDouble(request.getParameter("mileage"));
        int oddGasAmount=Integer.parseInt(request.getParameter("oddGasAmount"));
        int isGoodEngine=Integer.parseInt(request.getParameter("isGoodEngine"));
        int isGoodTran=Integer.parseInt(request.getParameter("isGoodTran"));
        int isGoodLight=Integer.parseInt(request.getParameter("isGoodLight"));
        int userId=Integer.parseInt(request.getParameter("userId").trim());
        int doorCount=Integer.parseInt(request.getParameter("doorCount").trim());
        int seatCount=Integer.parseInt(request.getParameter("seatCount").trim());

        CarInfoVO carInfoVO=new CarInfoVO();
        carInfoVO.setUserId(userId);
        carInfoVO.setBrandIndex(brandIndex);
        carInfoVO.setBrandTypeIndex(brandTypeIndex);
        carInfoVO.setCarFlag(carFlag);
        carInfoVO.setProvinceIndex(provinceIndex);
        carInfoVO.setCarLicenceTail(carLicenceTail);
        carInfoVO.setName(name);
        carInfoVO.setPhoneNum(phoneNum);
        carInfoVO.setMileage(mileage);
        carInfoVO.setChassisNum(chassisNum);
        carInfoVO.setEngineNum(engineNum);

        carInfoVO.setOddGasAmount(oddGasAmount);
        carInfoVO.setIsGoodEngine(isGoodEngine);
        carInfoVO.setIsGoodTran(isGoodTran);
        carInfoVO.setIsGoodLight(isGoodLight);
        carInfoVO.setDoorCount(doorCount);
        carInfoVO.setSeatCount(seatCount);
        carInfoVO.setState(0);

        System.out.println("AddCarInfo:"+JSONObject.fromObject(carInfoVO).toString());
        carMessageService.addCarInfo(carInfoVO);
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  车辆管理_扫描二维码 To 添加车辆信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/MyAddCarInfo",method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
    public void myAddCarInfo(HttpServletRequest request){
       int userId=Integer.parseInt(request.getParameter("userId"));
        CarInfoVO carInfoVO = new CarInfoVO();
        carInfoVO.setBrandIndex(5);//车牌索引
        carInfoVO.setBrandTypeIndex(1);//车牌类型索引
        carInfoVO.setCarLicenceTail("111");//车牌尾号
        carInfoVO.setDoorCount(5);
        carInfoVO.setSeatCount(3);
        carInfoVO.setCarFlag("mini.png");
        carInfoVO.setEngineNum("66668888");
        carInfoVO.setProvinceIndex(1);
        carInfoVO.setChassisNum("123456");
        carInfoVO.setCarLicenceTail("A12345");
        carInfoVO.setPhoneNum("13166837709");
        carInfoVO.setMileage(5001);
        carInfoVO.setOddGasAmount(95);
        carInfoVO.setIsGoodEngine(1);
        carInfoVO.setIsGoodLight(0);
        carInfoVO.setIsGoodTran(1);
        carInfoVO.setUserId(1);
        carInfoVO.setState(0);
        carMessageService.addCarInfo(carInfoVO);
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  车辆管理_更新车辆信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/UpdateCarInfo",method = RequestMethod.POST,produces ="text/plain;charset=UTF-8")
    public void updateCrInfo(HttpServletRequest request){

        int carInfoId=Integer.parseInt(request.getParameter("carInfoId"));

        int brandIndex=Integer.parseInt(request.getParameter("brandIndex"));


        int brandTypeIndex=Integer.parseInt(request.getParameter("brandTypeIndex"));
        String carFlag=request.getParameter("carFlag");
        int provinceIndex=Integer.parseInt(request.getParameter("provinceIndex"));
        String carLicenceTail=request.getParameter("carLicenceTail");
        String name=request.getParameter("name");
        String phoneNum=request.getParameter("phoneNum");
        String chassisNum=request.getParameter("chassisNum");
        String engineNum=request.getParameter("engineNum");
        Double mileage=Double.parseDouble(request.getParameter("mileage"));
        int oddGasAmount=Integer.parseInt(request.getParameter("oddGasAmount"));
        int isGoodEngine=Integer.parseInt(request.getParameter("isGoodEngine"));
        int isGoodTran=Integer.parseInt(request.getParameter("isGoodTran"));
        int isGoodLight=Integer.parseInt(request.getParameter("isGoodLight"));
        int state=Integer.parseInt(request.getParameter("state"));
        if(state==1){
         carMessageService.clearState();
        }

        CarInfoVO carInfoVO=new CarInfoVO();
        carInfoVO.setCarInfoId(carInfoId);
        carInfoVO.setBrandIndex(brandIndex);
        carInfoVO.setBrandTypeIndex(brandTypeIndex);
        carInfoVO.setCarFlag(carFlag);
        carInfoVO.setProvinceIndex(provinceIndex);
        carInfoVO.setCarLicenceTail(carLicenceTail);
        carInfoVO.setName(name);
        carInfoVO.setPhoneNum(phoneNum);
        carInfoVO.setMileage(mileage);
        carInfoVO.setChassisNum(chassisNum);
        carInfoVO.setEngineNum(engineNum);
        carInfoVO.setDoorCount(Integer.parseInt(request.getParameter("doorCount").trim()));
        carInfoVO.setDoorCount(Integer.parseInt(request.getParameter("seatCount").trim()));
        carInfoVO.setOddGasAmount(oddGasAmount);
        carInfoVO.setIsGoodEngine(isGoodEngine);
        carInfoVO.setIsGoodTran(isGoodTran);
        carInfoVO.setIsGoodLight(isGoodLight);
        carInfoVO.setState(state);
        System.out.println("UpdateCarInfo:"+JSONObject.fromObject(carInfoVO).toString());
        carMessageService.updateCarInfo(carInfoVO);
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  根据车辆信息表id号去删除车辆信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/DeleteCarInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public void deleteCarInfo(HttpServletRequest request){
        int carInfoId=Integer.parseInt(request.getParameter("carInfoId"));
        carMessageService.deleteCarInfo(carInfoId);
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  根据车辆信息表id号去删除车辆信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/GetZnwhInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getZnwhInfo(HttpServletRequest request){
      int userId=Integer.parseInt(request.getParameter("userId"));
        ZnwhInfoVO znwhInfoVO;
        if(carMessageService.getZnwhInfo(userId)!=null){
            znwhInfoVO=carMessageService.getZnwhInfo(userId);
            JSONObject jsonObject=new JSONObject();
            String json=jsonObject.fromObject(znwhInfoVO).toString();
            System.out.println(json);
            return json;
        }else {
            return "查询失败,该用户没有设置默认车辆.";
        }
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  更新智能维护的信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/UpdateZnwhInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String updateZnwhInfo(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId").trim());

       // ZnwhInfoVO znwhInfoVO=carMessageService.quryUser(userId);
       if (carMessageService.quryUser(userId)!=null){
           ZnwhInfoVO znwhInfoVO=carMessageService.quryUser(userId);
           //汽油量的多少
           int oddGasAmount=(int)(100*Math.random());

           znwhInfoVO.setOddGasAmount(oddGasAmount);
           //车灯异常情况
           double isGoodEngine=Math.random();
           if(isGoodEngine>0.95){
               znwhInfoVO.setIsGoodEngine(0);
           }else {
               znwhInfoVO.setIsGoodEngine(1);
           }
           //变速器异常情况
           double isGoodLight=Math.random();
           if(isGoodLight>0.95){
               znwhInfoVO.setIsGoodLight(0);
           }else {
               znwhInfoVO.setIsGoodLight(1);
           }
           //车引擎异常情况
           double isGoodTran=Math.random();
           if(isGoodLight>0.95){
               znwhInfoVO.setIsGoodTran(0);
           }else {
               znwhInfoVO.setIsGoodTran(1);
           }
           //行驶的公里数
           Random random=new Random();
           double mileage=znwhInfoVO.getMileage()+(random.nextDouble()*100);
           BigDecimal bd=new BigDecimal(mileage);
           mileage=bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
           znwhInfoVO.setMileage(mileage);
           carMessageService.updateZnwhInfo(znwhInfoVO);
           return "动态更新智能维护信息数据成功。";
       }else {
           return "查询失败,用户没有设置默认车辆。";
       }
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  车辆管理_获取违章信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/GetWeiZhangInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getWeiZhangInfo(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId").toString().trim());
        WeiZhangInfoVO weiZhangInfoVO=carMessageService.getWeiZhangInfo(userId);
        if(weiZhangInfoVO==null){
            return "error";
        }else {
            JSONObject jsonObject=new JSONObject();
            String json=jsonObject.fromObject(weiZhangInfoVO).toString();
            System.out.println(json);
            return json;
        }
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  根据用户id号，查询是否存在该车辆
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Car/QueryCar",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String QueryCar(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId").toString().trim());
       ZnwhInfoVO znwhInfoVO=carMessageService.quryUser(userId);
        System.out.println("QueryCar:"+JSONObject.fromObject(znwhInfoVO).toString());
        if(znwhInfoVO!=null){
            return "exist";
        }else {
            return "noexist";
        }
    }

    /**
     * @author  Aaron_qiuyong
     * @discription  获取专属保养手册信息
     * @param request
     * @return String
     */
    @RequestMapping(value = "/Car/QueryByscContent",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String QueryByscContent(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        System.out.println("QueryByscContent:uId:"+userId);
        ZnwhInfoVO znwhInfoVO=carMessageService.quryUser(userId);
        if(null!=znwhInfoVO){
            Map<String,Object> map=new HashMap<String,Object>();
            double byscKm=znwhInfoVO.getMileage();
            map.put("byscKm",byscKm);
            List<ByscVO> list=new ArrayList<ByscVO>();
            list.add(Utils.jyjlState(byscKm));
            list.add(Utils.klState(byscKm));
            list.add(Utils.ktlxState(byscKm));
            list.add(Utils.bsxyState(byscKm));
            list.add(Utils.zxyState(byscKm));
            list.add(Utils.zxtState(byscKm));
            list.add(Utils.hhsState(byscKm));
            list.add(Utils.scyState(byscKm));
            map.put("byscList",list);
            String json=JSONObject.fromObject(map).toString();
            System.out.println("QueryByscContent:json:"+json);
            return json;
        }
        return "error";
    }
}
