package com.wind.location;

import com.wind.location.model.UserLocationVO;
import com.wind.location.service.LocationService;
import com.wind.user.model.UserVO;
import com.wind.user.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
* @author qiuyong
* 有关用户位置的控制层
*/
@Controller
public class LocationController {
    @Autowired
    LocationService locationService;//与用户所处位置有关的服务层

    @Autowired
    UserService userService;//与用户相关的用户

    /**
     * @author  Aaron_qiuyong
     * @discription  每间隔一段时间获取用户位置,实现实时监听
     * @param request
     * @return String
     */
    @RequestMapping(value="/location/saveUserLocation",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String saveUserLocation(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();

        int userId=Integer.parseInt(request.getParameter("userId"));
        UserVO userVO=userService.findUserInfoById(userId);
        if(null==userVO){
            map.put("success",false);
            map.put("msg","用户异常,请重新登陆重试!");
            String json= JSONObject.fromObject(map).toString();
            System.out.println("saveUserLocation:"+json);
            return json;
        }
        double userLat=Double.parseDouble(request.getParameter("userLat"));//纬度
        double userLng=Double.parseDouble(request.getParameter("userLng"));//经度
        UserLocationVO userLocation=locationService.findUserLocationByUserId(userId);
        if(null!=userLocation){
            UserLocationVO locationVO=new UserLocationVO();
            locationVO.setUserId(userId);
            locationVO.setUserLat(userLat);
            locationVO.setUserLng(userLng);
            locationService.updateUserLocation(locationVO);
            map.put("success",true);
            map.put("msg","用户位置更新完毕!");
            String json=JSONObject.fromObject(map).toString();
            System.out.println("saveUserLocation:"+json);
            return json;
        }
        UserLocationVO userLocationVO=new UserLocationVO(userId,userLat,userLng);
        locationService.saveUserLocation(userLocationVO);
        map.put("success",true);
        map.put("msg","用户位置更新完毕!");
        String json=JSONObject.fromObject(map).toString();
        System.out.println("saveUserLocation:"+json);
        return json;
    }

}
