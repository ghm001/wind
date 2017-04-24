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

    /**
     * @author  Aaron_qiuyong
     * @discription 用户登录
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/UserLogin",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String login(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String userPass=request.getParameter("userPass");
        System.out.println("UserLogin:"+userName);
        UserVO userVO;
        userVO=userService.getUserInfo(userName);
        if (userVO!=null&&userVO.getUserPass().equals(userPass)){
            userVO.setMessage("success");
        }else{
            userVO=new UserVO();
            userVO.setMessage("error");
        }
        String json=new JSONObject().fromObject(userVO).toString();
        System.out.println("UserLogin:"+json);
        return json;
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 用户注册
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "UserRegister",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String register(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        System.out.println("UserRegister:"+userName + "---" + userPass);
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        userVO.setUserPass(userPass);
        userService.saveUserInfo(userVO);
        return "OK";
     }

    /**
     * @author  Aaron_qiuyong
     * @discription 判断用户是否存在
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "UserJudge",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String judgeUser(HttpServletRequest request){
        String userName=request.getParameter("userName");
        UserVO userVO=userService.getUserInfo(userName);
        if(userVO!=null){
            return "error";
        }else {
            return "success";
        }
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 上传用户头像
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "AddUserIcon",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String addUserIcon(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String s=request.getParameter("userIconContent");
        //获取服务器存放图片的路径
        String path=request.getSession().getServletContext().getRealPath("/img/user_icon");
        //生成图片的随
        // 机数
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

    /**
     * @author  Aaron_qiuyong
     * @discription 修改用户信息
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "UpdateUserInfo",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String updateUserInfo(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String sex=request.getParameter("sex");
        String nickname=request.getParameter("nickname");
        String iAge=request.getParameter("age");
        String driverNum=request.getParameter("driverNum");
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

    /**
     * @author  Aaron_qiuyong
     * @discription 修改用户密码
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "user/UpdateUserPass" , method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String updateUserPass(HttpServletRequest request){
        Map<String,Object> rtnMap=new HashMap<String, Object>();
        String userName=request.getParameter("userName");
        String newUserPass=request.getParameter("newUserPass");
       UserVO userVO=userService.getUserInfo(userName);
        if(null!=userVO){
            userVO.setUserPass(newUserPass);
            userService.updateUserPass(userVO);
            //修改登录状态
            UserVO uVO=new UserVO();
            uVO.setUserId(userVO.getUserId());
            uVO.setLoginFlag(0);
            userService.updateLoginFlagByUserId(uVO);
            rtnMap.put("success",true);
            rtnMap.put("msg","密码修改成功!");
            return JSONObject.fromObject(rtnMap).toString();
        }
        rtnMap.put("success",false);
        rtnMap.put("msg","输入的用户名有误!");
        return JSONObject.fromObject(rtnMap).toString();
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 判断旧密码是否存在
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "user/JdugeUserPass" , method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String JudgeUserPass(HttpServletRequest request){
        Map<String,Object> rtnMap=new HashMap<String, Object>();
        String userName=request.getParameter("userName");
        String oldUserPass=request.getParameter("oldUserPass");
        //通过用户名获得用户信息
        UserVO userVO=userService.getUserInfo(userName);
        if(userVO==null){
            rtnMap.put("success",false);
            rtnMap.put("msg","输入的用户名不存在!");
            return JSONObject.fromObject(rtnMap).toString();
        }
        if(null!=userVO&&!userVO.getUserPass().equals(oldUserPass)){
            rtnMap.put("success",false);
            rtnMap.put("msg","输入的旧密码有误!");
            return JSONObject.fromObject(rtnMap).toString();
        }
        rtnMap.put("success",true);
        rtnMap.put("msg","账号密码校验成功!");
        return JSONObject.fromObject(rtnMap).toString();
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 修改用户登录标识
     * @param request
     * @return String
     */
    @RequestMapping(value = "user/ChangeLoginFlag" , method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String changeLoginFlag(HttpServletRequest request){
        Map<String,Object> rtnMap=new HashMap<String, Object>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        int loginFlag=Integer.parseInt(request.getParameter("loginFlag"));
        System.out.println("ChangeLoginFlag:"+"userId-"+userId+"loginFlag-"+loginFlag);
        UserVO userVO=userService.findUserInfoById(userId);
        if(null!=userVO){
            userVO.setUserId(userId);
            userVO.setLoginFlag(loginFlag);
            userService.updateLoginFlagByUserId(userVO);
            rtnMap.put("success",true);
            rtnMap.put("msg","登陆状态更新完毕!");
            return JSONObject.fromObject(rtnMap).toString();
        }
        rtnMap.put("success",false);
        rtnMap.put("msg","登陆状态更改失败,请检查你的网络或者输入是否有误!");
        return JSONObject.fromObject(rtnMap).toString();
    }




}

