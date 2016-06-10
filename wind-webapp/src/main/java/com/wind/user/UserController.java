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
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println(userVO.getUserId()+"");
        System.out.println(userVO.getUserIconUrl());

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
        //获取服务器存放图片的路径
        String path=request.getSession().getServletContext().getRealPath("/img/user_icon");
        //生成图片的随机数
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String time=dateFormat.format(date);

        //图片文件的名称
        String fileName="/"+userName.trim()+time.trim()+".png";

        //创建图片文件
       File img=new File(path+fileName);

       String oldFile=userService.getUserInfo(userName).getUserIconUrl();
        File file=new File(path+oldFile);
        if(file.exists()){
            file.delete();
        }
        try {
            //向服务器端写文件
            byte [] user=new BASE64Decoder().decodeBuffer(s);
            OutputStream os=new FileOutputStream(img);
            os.write(user,0,user.length);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserVO userVO=new UserVO();
        userVO.setUserName(userName);
        userVO.setUserIconUrl(fileName);
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

    @ResponseBody
    @RequestMapping(value = "UploadImage",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String uploadImage(HttpServletRequest request){

        return null;
    }



}

