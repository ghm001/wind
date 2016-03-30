package com.wind.utils.annotation.mybatis.untils;



import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2015/12/21.
 */
public class AnalysisRequest {

    public static String getRequest(HttpServletRequest request){
        StringBuffer sb=new StringBuffer();
        String line=null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            while((line = br.readLine())!=null){
                sb.append(line);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return"";
    }
}
