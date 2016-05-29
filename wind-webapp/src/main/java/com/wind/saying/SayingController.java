package com.wind.saying;

import com.wind.common.ImageUtil;
import com.wind.order.model.OrderVO;
import com.wind.saying.model.SayingVO;
import com.wind.saying.service.SayingService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
@Controller
public class SayingController {
    @Autowired
    SayingService sayingService;

    @ResponseBody
    @RequestMapping(value = "/Saying/GetQzSayings",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getQzSayings(HttpServletRequest request){
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getQzSayings();
        JSONArray jsonArray=new JSONArray();
        String json=jsonArray.fromObject(list).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Saying/GetCzwSaying",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getCzwSayings(HttpServletRequest request){
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getCzwSayings();
        JSONArray jsonArray=new JSONArray();
        String json=jsonArray.fromObject(list).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Saying/AddSaying",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public void addSaying(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        Date postTime=new Date();
        String postAddress=request.getParameter("postAddress");
        String sayingContent=request.getParameter("sayingContent");
        int sayingType=Integer.parseInt(request.getParameter("sayingType"));
        String img1="",img2="",img3="",img4="",img5="",img6="";

        //获取服务器存放图片的路径
        String path=request.getSession().getServletContext().getRealPath("/img/saying_img");

        if(request.getParameter("img1")!=null&&request.getParameter("img2").equals("")){
           String img1Content=request.getParameter("img1");
           img1= ImageUtil.uploadImg(img1,path,img1Content);
        }

        if(request.getParameter("img2")!=null&&request.getParameter("img2").equals("")){
          String  img2Content=request.getParameter("img2");
          img2=  ImageUtil.uploadImg(img2,path,img2Content);
        }

        if(request.getParameter("img3")!=null&&request.getParameter("img3").equals("")){
           String img3Content=request.getParameter("img3");
            img3= ImageUtil.uploadImg(img3,path,img3Content);
        }

        if(request.getParameter("img4")!=null&&request.getParameter("img4").equals("")){
            String img4Content=request.getParameter("img4");
            img4=ImageUtil.uploadImg(img4,path,img4Content);
        }

        if(request.getParameter("img5")!=null&&request.getParameter("img5").equals("")){
            String img5Content=request.getParameter("img5");
           img5= ImageUtil.uploadImg(img5,path,img5Content);
        }

        if(request.getParameter("img6")!=null&&request.getParameter("img6").equals("")){
            String img6Content=request.getParameter("img6");
           img6= ImageUtil.uploadImg(img6,path,img6Content);
        }
        SayingVO sayingVO=new SayingVO(userId,postTime,sayingContent,postAddress,sayingType,img1,img2,img3,img4,img5,img6);
        sayingService.addSaying(sayingVO);
    }

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
