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

        int totalItemCount=Integer.parseInt(request.getParameter("totalItemCount"));
        System.out.println(totalItemCount);
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getQzSayings();
        List<SayingVO>  tempList=new ArrayList<SayingVO>();
        System.out.println(list.size());
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
        System.out.println(tempList.size());
        JSONArray jsonArray=new JSONArray();
        String json=jsonArray.fromObject(tempList).toString();
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/Saying/GetCzwSayings",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getCzwSayings(HttpServletRequest request){
        int totalItemCount=Integer.parseInt(request.getParameter("totalItemCount"));
        System.out.println(totalItemCount);
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getCzwSayings();
        List<SayingVO>  tempList=new ArrayList<SayingVO>();
        System.out.println(list.size());
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
        System.out.println(tempList.size());
        JSONArray jsonArray=new JSONArray();
        String json=jsonArray.fromObject(tempList).toString();
        return json;
    }

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
        System.out.println(imgxContent);
        if(request.getParameter("img1")!=null&&!request.getParameter("img1").equals("")){
           String img1Content=request.getParameter("img1");
            System.out.println(img1Content);
           img1= ImageUtil.uploadImg("img1",path,img1Content);
            System.out.print(img1+"");
        }

        if(request.getParameter("img2")!=null&&!request.getParameter("img2").equals("")){
          String  img2Content=request.getParameter("img2");
            System.out.println(img2Content);
            img2=  ImageUtil.uploadImg("img2",path,img2Content);
        }

        if(request.getParameter("img3")!=null&&!request.getParameter("img3").equals("")){
           String img3Content=request.getParameter("img3");
            System.out.println(img3Content);
            img3= ImageUtil.uploadImg("img3",path,img3Content);
        }

        if(request.getParameter("img4")!=null&&!request.getParameter("img4").equals("")){
            String img4Content=request.getParameter("img4");
            System.out.println(img4Content);
            img4=ImageUtil.uploadImg("img4",path,img4Content);
        }

        if(request.getParameter("img5")!=null&&!request.getParameter("img5").equals("")){
            String img5Content=request.getParameter("img5");
            System.out.println(img5Content);
            img5= ImageUtil.uploadImg("img5",path,img5Content);
        }

        if(request.getParameter("img6")!=null&&!request.getParameter("img6").equals("")){
            String img6Content=request.getParameter("img6");
            System.out.println(img6Content);
            img6= ImageUtil.uploadImg("img6",path,img6Content);
        }
        SayingVO sayingVO=new SayingVO(userId,postTime,strTime,postAddress,sayingContent,sayingType,img1,img2,img3,img4,img5,img6);
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
