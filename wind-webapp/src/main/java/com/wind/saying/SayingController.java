package com.wind.saying;

import com.google.gson.JsonObject;
import com.wind.common.ImageUtil;
import com.wind.common.LocationUtil;
import com.wind.location.model.UserLocationVO;
import com.wind.location.service.LocationService;
import com.wind.order.model.OrderVO;
import com.wind.saying.model.SayingVO;
import com.wind.saying.service.SayingService;
import com.wind.user.model.UserVO;
import com.wind.user.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/5/29.
 */
@Controller
public class SayingController {
    @Autowired
    SayingService sayingService;

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    /**
     * @author  Aaron_qiuyong
     * @discription 获取求助说说列表
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Saying/GetQzSayings",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getQzSayings(HttpServletRequest request){

        int totalItemCount=Integer.parseInt(request.getParameter("totalItemCount"));
        System.out.println("GetQzSayings-totalItemCount:"+totalItemCount);
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getQzSayings();
        List<SayingVO>  tempList=new ArrayList<SayingVO>();
        if(list==null&&list.size()==0){
            return "no_saying";
        }else{
            if(list.size()<=totalItemCount){
                return "load_all";
            }else if(list.size()>=totalItemCount+20){
                for(int i=totalItemCount;i<totalItemCount+20;i++){
                    tempList.add(list.get(i));
                }
            }else if(list.size()>0&&list.size()<totalItemCount+20){
                for (int i=totalItemCount;i<list.size();i++){
                    tempList.add(list.get(i));
                }
            }
        }
        JSONArray jsonArray=new JSONArray();
        String json=jsonArray.fromObject(tempList).toString();
        return json;
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 获取发动态的信息列表
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Saying/GetCzwSayings",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getCzwSayings(HttpServletRequest request){
        int totalItemCount=Integer.parseInt(request.getParameter("totalItemCount"));
        System.out.println("GetCzwSayings-totalItemCount:"+totalItemCount);
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getCzwSayings();
        List<SayingVO>  tempList=new ArrayList<SayingVO>();
        if(list==null&&list.size()==0){
            return "no_saying";
        }else{
            if(list.size()<=totalItemCount){
                return "load_all";
            }else if(list.size()>=totalItemCount+20){
                for(int i=totalItemCount;i<totalItemCount+20;i++){
                    tempList.add(list.get(i));
                }
            }else if(list.size()>0&&list.size()<totalItemCount+20){
                for (int i=totalItemCount;i<list.size();i++){
                    tempList.add(list.get(i));
                }
            }
        }
        JSONArray jsonArray=new JSONArray();
        String json=jsonArray.fromObject(tempList).toString();
        return json;
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 添加说说
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Saying/AddSaying",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public void addSaying(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        Date postTime=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime=format.format(postTime);

        String postAddress=request.getParameter("postAddress");
        String sayingContent=request.getParameter("sayingContent");

        int sayingType=Integer.parseInt(request.getParameter("sayingType"));
        String img1="",img2="",img3="",img4="",img5="",img6="";

        //获取服务器存放图片的路径
        String path=request.getSession().getServletContext().getRealPath("/img/saying_img");

        String imgxContent=request.getParameter("img1");
        if(request.getParameter("img1")!=null&&!request.getParameter("img1").equals("")){
           String img1Content=request.getParameter("img1");
           img1= ImageUtil.uploadImg("img1",path,img1Content);
        }

        if(request.getParameter("img2")!=null&&!request.getParameter("img2").equals("")){
          String  img2Content=request.getParameter("img2");
            img2=  ImageUtil.uploadImg("img2",path,img2Content);
        }

        if(request.getParameter("img3")!=null&&!request.getParameter("img3").equals("")){
           String img3Content=request.getParameter("img3");
            img3= ImageUtil.uploadImg("img3",path,img3Content);
        }

        if(request.getParameter("img4")!=null&&!request.getParameter("img4").equals("")){
            String img4Content=request.getParameter("img4");
            img4=ImageUtil.uploadImg("img4",path,img4Content);
        }

        if(request.getParameter("img5")!=null&&!request.getParameter("img5").equals("")){
            String img5Content=request.getParameter("img5");
            img5= ImageUtil.uploadImg("img5",path,img5Content);
        }

        if(request.getParameter("img6")!=null&&!request.getParameter("img6").equals("")){
            String img6Content=request.getParameter("img6");
            img6= ImageUtil.uploadImg("img6",path,img6Content);
        }
        SayingVO sayingVO=new SayingVO(userId,postTime,strTime,sayingContent,postAddress,sayingType,img1,img2,img3,img4,img5,img6);
        sayingService.addSaying(sayingVO);

        //发送紧急求助的方法  当该用户距离为小于3000米的时候。
        if(sayingType!=1){
            Map<String,String> map=new HashMap<String, String>();
            UserVO userVO=userService.findUserInfoById(userId);
            if(null!=userVO){
                //获取当前用户的经纬度
                UserLocationVO userLocationVO=locationService.findUserLocationByUserId(userId);
                String lat=userLocationVO.getUserLat()+"";
                String lng=userLocationVO.getUserLng()+"";
                map.put("qzrLat",lat);//求助人的纬度
                map.put("qzrLng",lng);//求助人的经度
                map.put("qzrUserName",userVO.getUserName());//求助人的手机号码
                map.put("qzrNickName",userVO.getNickname());//求助人的昵称
                map.put("qzrUserIconUrl",userVO.getUserIconUrl());//求助人的用户头像Url
                map.put("qzrPostContent",sayingContent);//求助人发表的求助内容
                if(null==postAddress){
                    map.put("qzrPostAddress","");
                }else{
                    map.put("qzrPostAddress",postAddress);//求助人发表求助的地址
                }
                //遍历数据库存在的所有用户
                List<UserLocationVO> ls=locationService.findAllUserLocation();

                if(null!=ls&&ls.size()>0){
                    String title="用户:"+userVO.getNickname()+"("+userVO.getUserName()+")在你附近遇到了困难";
                    String alert=sayingContent;
                    for(int k=0;k<ls.size();k++){
                        //遍历数据库的所有用户的经纬度
                        String tlat=ls.get(k).getUserLat()+"";
                        String tlng=ls.get(k).getUserLng()+"";
                        //两者之间的距离
                        String distanceBetweenTwoPeople=LocationUtil.getDistance(lat,lng,tlat,tlng);
                        System.out.println("distanceBetweenTwoPeople:"+distanceBetweenTwoPeople);
                        if(Double.parseDouble(distanceBetweenTwoPeople)>0&&Double.parseDouble(distanceBetweenTwoPeople)<3000){
                            String tag=ls.get(k).getUserId()+"";//针对不同用户的tag标记
                           String jsonStr=new JSONObject().fromObject(map).toString();
                            System.out.println("求助消息:"+jsonStr);
                            LocationUtil.pushQzMessage(tag,alert,title,map);
                        }
                    }
                }
            }
        }
    }

    /**
     * @author  Aaron_qiuyong
     * @discription 根据说说id号删除指定说说
     * @param request
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/Saying/DeleteSaying",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String deleteSaying(HttpServletRequest request){
       int sayingId=Integer.parseInt(request.getParameter("sayingId"));
        SayingVO sayingVO=sayingService.getSaying(sayingId);
        if(sayingVO!=null){
            sayingService.deleteSaying(sayingId);
            return  "删除成功";
        }else{
            return "删除失败";
        }
    }


}
