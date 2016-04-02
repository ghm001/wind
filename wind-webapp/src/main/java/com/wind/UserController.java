package com.wind;

import com.wind.user.model.UserVO;
import com.wind.user.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/12/21.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/UserLogin",method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request){
        String userId = request.getParameter("userId");
        System.out.println(userId);
        UserVO userVO;
        userVO= userService.getUserInfo(userId);//json数据格式
        /*
        if (User != null&&User.getPassword().equals(request.getParameter("password"))){
            User.setMessage("success");
        }else {
            User = new User();
            User.setMessage("error");
        }*/
        String json= new JSONObject().fromObject(userVO).toString();//Gson解析  userId
        System.out.println(json);
        return json;

    }
}

