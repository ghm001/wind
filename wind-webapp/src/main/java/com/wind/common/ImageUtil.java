package com.wind.common;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/29.
 */
public class ImageUtil {
    public static String uploadImg(String imgName,String path,String ImageContent){

        //生成图片的随机数
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String time=dateFormat.format(date);

        //图片文件的名称
        String fileName="/"+imgName.trim()+time.trim()+".png";

        //创建图片文件
        File imgFile=new File(path+fileName);


        try {
            //向服务器端写文件
            byte [] bytes=new BASE64Decoder().decodeBuffer(ImageContent);
            OutputStream os=new FileOutputStream(imgFile);
            os.write(bytes,0,bytes.length);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return fileName;
    }
}
