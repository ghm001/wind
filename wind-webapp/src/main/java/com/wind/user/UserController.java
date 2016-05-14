package com.wind.user;

import com.google.gson.Gson;
import com.wind.common.JsonUtil;
import com.wind.user.model.UserVO;
import com.wind.user.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/21.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/UserLogin",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String login(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String userPass=request.getParameter("userPass");
        System.out.println(userName);
        UserVO userVO;
        userVO=userService.getUserInfo(userName);


        System.out.println(userVO.getUserIconContent());

        if (userVO!=null&&userVO.getUserPass().equals(userPass)){
            userVO.setMessage("success");
        }else{
            userVO=new UserVO();
            userVO.setMessage("error");
        }
        String json=new JSONObject().fromObject(userVO).toString();
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "UserRegister",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String register(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        System.out.println(userName + "------" + userPass);
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        userVO.setUserPass(userPass);

        userService.saveUserInfo(userVO);
        return "OK";
     }


    @ResponseBody
    @RequestMapping(value = "UserJudge",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String judgeUser(HttpServletRequest request){
        String userName=request.getParameter("userName");

        System.out.println(userName);
        UserVO userVO;
        userVO=userService.getUserInfo(userName);
        if(userVO!=null){
            return "error";
        }else {
            return "success";
        }
    }

    @ResponseBody
    @RequestMapping(value = "AddUserIcon",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String addUserIcon(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String s=request.getParameter("userIconContent");

        byte[]  userIconContent= s.getBytes();
       /*
        byte[] swww = new byte[1024*20];

        File img  = new File("D:\\intelij-workspace\\wind\\wind-webapp\\target\\wind-webapp\\img\\background\\" + "ddd.png" );
        try{
            FileOutputStream os = new FileOutputStream("D:\\intelij-workspace\\wind\\wind-webapp\\target\\wind-webapp\\img\\background\\" + "ddd.png");
            os.write(userIconContent,0,userIconContent.length);
            os.flush();
            os.close();
        } catch (Exception r) {

        }*/

        System.out.println(userName);
        System.out.println(userIconContent);
        UserVO userVO=new UserVO();
        userVO.setUserName(userName);
        userVO.setUserIconContent(userIconContent);
        userService.addUserIcon(userVO);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "UpdateUserInfo",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String updateUserInfo(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String sex=request.getParameter("sex");
        String nickname=request.getParameter("nickname");
        String iAge=request.getParameter("age");
        String driverNum=request.getParameter("driverNum");
        System.out.println(userName);
        UserVO userVO=new UserVO();

        userVO.setUserName(userName);
        userVO.setSex(sex);
        userVO.setNickname(nickname);
        int age=Integer.parseInt(iAge);
        userVO.setAge(age);
        userVO.setDriverNum(driverNum);
        userService.updateUserInfo(userVO);
        return "ok";
    }

}

