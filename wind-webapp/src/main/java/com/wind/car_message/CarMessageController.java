package com.wind.car_message;

import com.wind.carMessage.model.BrandVO;
import com.wind.carMessage.model.CarInfoVO;
import com.wind.carMessage.model.WeiZhangInfoVO;
import com.wind.carMessage.model.ZnwhInfoVO;
import com.wind.carMessage.service.CarMessageService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/4/30.
 */

@Controller
public class CarMessageController {
    @Autowired
    private CarMessageService carMessageService;

    @ResponseBody
    @RequestMapping(value = "/Car/BrandInfo",method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
    public String getBrandInfoList(){
        List<BrandVO> list=new ArrayList<BrandVO>();
        list=carMessageService.getCarBrandInfo();
        String json=new JSONArray().fromObject(list).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Car/CarInfo",method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
    public String getCarInfoList(){
        List<CarInfoVO> list=new ArrayList<CarInfoVO>();
        list=carMessageService.getAllCarInfo();
        String json=new JSONArray().fromObject(list).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Car/AddCarInfo",method = RequestMethod.POST,produces ="text/plain;charset=UTF-8")
    public void addCrInfo(HttpServletRequest request){

        int brandIndex=Integer.parseInt(request.getParameter("brandIndex"));
        System.out.println(brandIndex);

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

        CarInfoVO carInfoVO=new CarInfoVO();
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

        System.out.println(carInfoVO.getName());
        carMessageService.addCarInfo(carInfoVO);
    }

    @ResponseBody
    @RequestMapping(value = "/Car/MyAddCarInfo",method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
    public void myAddCarInfo(HttpServletRequest request){

        int brandIndex=Integer.parseInt(request.getParameter("brandIndex"));
        System.out.println(brandIndex);
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

        CarInfoVO carInfoVO=new CarInfoVO();
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

        System.out.println(carInfoVO.getName());
        carMessageService.addCarInfo(carInfoVO);
    }

    @ResponseBody
    @RequestMapping(value = "/Car/UpdateCarInfo",method = RequestMethod.POST,produces ="text/plain;charset=UTF-8")
    public void updateCrInfo(HttpServletRequest request){

        int carInfoId=Integer.parseInt(request.getParameter("carInfoId"));
        System.out.println(carInfoId);
        int brandIndex=Integer.parseInt(request.getParameter("brandIndex"));
        System.out.println(brandIndex);

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

        carInfoVO.setOddGasAmount(oddGasAmount);
        carInfoVO.setIsGoodEngine(isGoodEngine);
        carInfoVO.setIsGoodTran(isGoodTran);
        carInfoVO.setIsGoodLight(isGoodLight);
        carInfoVO.setState(state);
        System.out.println(carInfoVO.getName());

        carMessageService.updateCarInfo(carInfoVO);
    }

    @ResponseBody
    @RequestMapping(value = "/Car/DeleteCarInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public void deleteCarInfo(HttpServletRequest request){
        int carInfoId=Integer.parseInt(request.getParameter("carInfoId"));
        carMessageService.deleteCarInfo(carInfoId);
    }

    @ResponseBody
    @RequestMapping(value = "/Car/GetZnwhInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getZnwhInfo(HttpServletRequest request){
      int userId=Integer.parseInt(request.getParameter("userId"));
        System.out.println(userId + "");
        ZnwhInfoVO znwhInfoVO;
        if(carMessageService.getZnwhInfo(userId)!=null){
            znwhInfoVO=carMessageService.getZnwhInfo(userId);
            JSONObject jsonObject=new JSONObject();
            String json=jsonObject.fromObject(znwhInfoVO).toString();
            return json;
        }else {
            return "查询失败,该用户没有设置默认车辆.";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/Car/UpdateZnwhInfo",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String updateZnwhInfo(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId").trim());
        System.out.println(userId+"");
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
           System.out.println(mileage);
           BigDecimal bd=new BigDecimal(mileage);
           mileage=bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
           System.out.println(mileage);
           znwhInfoVO.setMileage(mileage);
           carMessageService.updateZnwhInfo(znwhInfoVO);
           return "动态更新智能维护信息数据成功。";
       }else {
           return "查询失败,用户没有设置默认车辆。";
       }
    }

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
            return json;
        }
    }
}
