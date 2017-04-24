package com.wind.user.dao;

import com.wind.user.model.UserVO;
import com.wind.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class UserDaoTest {

    @Autowired
    UserService userService;

    //查询用户对用户登录进行校验-获得用户信息并显示-校验是否存在用户对注册进行判断
    @Test
    public void testGetUserInfo() {
        UserVO userVO;
        String userName = "13166837709";
        userVO = userService.getUserInfo(userName);
        userVO.setMessage("success");
        System.out.println("用户名:" + userVO.getUserName());
        System.out.println("密码:" + userVO.getUserPass());
        System.out.println("昵称:" + userVO.getNickname());
        System.out.println("性别:" + userVO.getSex());
        System.out.println("年龄:" + userVO.getAge());
        System.out.println("驾驶证号:" + userVO.getDriverNum());
        System.out.println("用户头像:" + userVO.getUserIconUrl());
        System.out.println("登录状态:" + userVO.getMessage());
    }

    //注册用户-利用手机号与密码（通过短信注册）
    @Test
    public void saveUserInfo() {
        String userName = "13037491879";
        String userPass = "110110";
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        userVO.setUserPass(userPass);
        userService.saveUserInfo(userVO);
        System.out.println("注册成功");
    }

    //添加或者修改用户头像
    @Test
    public void addUserIcon() {
        String userName = "13037491879";//对刚才的用户进行头像添加
        String userIconUrl = "/1351431842220160604115838.png";//由于要获取头像的byte[]，所以不在I这里进行文件的读写操作了。
    /*
    public static String uploadImg(String imgName, String path, String ImageContent) {
        //生成图片的随机数
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(date);
        //图片文件的名称
        String fileName = "/" + imgName.trim() + time.trim() + ".png";
        System.out.println(fileName);
        //创建图片文件
        File imgFile = new File(path + fileName);
        System.out.println(path + fileName);
        try {
            //向服务器端写文件
            byte[] bytes = new BASE64Decoder().decodeBuffer(ImageContent);
            OutputStream os = new FileOutputStream(imgFile);
            os.write(bytes, 0, bytes.length);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
    */
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        userVO.setUserIconUrl(userIconUrl);
        userService.addUserIcon(userVO);
    }

    //修改用户信息-这些信息均为选填
    @Test
    public void updateUserInfo() {
        UserVO userVO = new UserVO();
        userVO.setAge(50);//年龄
        userVO.setSex("男");//性别
        userVO.setDriverNum("431022199603251313");//驾驶证号
        userVO.setNickname("克里斯蒂亚诺·罗纳尔多");//昵称
        userVO.setUserName("13037491879");//指定用户对象
        userService.updateUserInfo(userVO);
    }

    //修改用户密码
    @Test
    public void updatePassword() {
        String userName = "13037491879";
        String oldPass = "110110".trim();
        UserVO userVO = userService.getUserInfo("13037491879");
        if (userVO != null && userVO.getUserPass().equals(oldPass)) {
            String newPass = "1112233";
            UserVO user = new UserVO();
            user.setUserName(userName);
            user.setUserPass(newPass);
            userService.updateUserPass(user);
            System.out.println("修改密码成功");
        } else {
            System.out.println("不存在该用户或用户名|密码有误");
        }
    }

    //通过用户id去获取用户
    @Test
    public void testFindUserById(){
        int userId=1;
       UserVO userVO=  userService.findUserInfoById(userId);
        if(userVO==null){
            System.out.println("error");
        }else{
            System.out.println("success");
        }
    }

    //修改用户密码
    @Test
    public void tesUpdateUserPass(){
        String userName="13166837709";
        String userPass="1234567";
        UserVO userVO=new UserVO();
        userVO.setUserName(userName);
        userVO.setUserPass(userPass);
        userService.updateUserPass(userVO);
    }

    //修改用户的登录状态
    @Test
    public void testChangeLoginFlagByUserId(){
        UserVO userVO=new UserVO();
        userVO.setUserId(1);
        userVO.setLoginFlag(0);
        userService.updateLoginFlagByUserId(userVO);
    }


}