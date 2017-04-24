package com.wind.common;


import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.google.gson.JsonObject;
import org.apache.commons.logging.Log;

import java.util.HashMap;
import java.util.Map;

public class LocationUtil {
    //地球半径
    private static double EARTH_RADIUS = 6378137;
   //极客推送发发送对象
   private final static JPushClient jpushClient = new JPushClient("f0f6c8179bcff96d34242edd", "ef069f69ab55d4c2beddf8cb", 3);

    /**
     *   根据经纬度计算两者之间的距离
     * @param lat1Str 用户1的纬度
     * @param lng1Str 用户1的经度
     * @param lat2Str 用户2的纬度
     * @param lng2Str 用户 2的纬度
     * @return String值(单位是米)
     */
    public static String getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
        Double lat1 = Double.parseDouble(lat1Str);
        Double lng1 = Double.parseDouble(lng1Str);
        Double lat2 = Double.parseDouble(lat2Str);
        Double lng2 = Double.parseDouble(lng2Str);

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000) / 10000;
        String distanceStr = distance+"";
        distanceStr = distanceStr.
                substring(0, distanceStr.indexOf("."));

        return distanceStr;
    }

    /**
     *  根据经纬度获得弧度
     * @param d 经纬度
     * @return double
     */
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     *
     * @param tag 为android端的用户提供一个标识
     * @param alert 为android端的通知栏提供消息  即为消息的内容
     * @param title 为android的通知栏提供消息   即为消息的标题
     * @return PushPayload
     */
    public static PushPayload buildPushObject_android_tag_alertWithTitle(String tag,String alert,String title) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.android(alert, title, null))
                .build();
    }

    /**
     *
     * @param tag 为android端的用户提供一个标识
     * @param alert 为android端的通知栏提供消息  即为消息的内容
     * @param title 为android的通知栏提供消息   即为消息的标题
     * @
     * @return PushPayload
     */
    public static PushPayload buildPushObject_android_and_ios(String tag,String alert,String title,String jsonStr) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.newBuilder()
                        .setAlert(alert)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title).build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("jsonStr", jsonStr)
                                .build())

                        .build())
                .build();
    }

    /**
     *
     * @param tag 为android端的用户提供一个标识
     * @param alert 为android端的通知栏提供消息  即为消息的内容
     * @param title 为android的通知栏提供消息   即为消息的标题
     * @return PushPayload
     */
    public static PushPayload buildPushObject_android_and_ios2(String tag,String alert,String title,Map<String,String> map) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.newBuilder()
                        .setAlert(alert)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title).build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(map).build())
                        .build())
                .build();
    }

    /**
     * @discrimination 极光推送消息
     * @param tag
     * @param alert
     * @param title
     * @param map
     */
    public static void pushQzMessage(String tag,String alert,String title,Map<String,String> map){
        PushPayload payload = buildPushObject_android_and_ios2(tag, alert, title,map);

        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);


        } catch (APIConnectionException e) {
            System.out.println("Connection error, should retry later" + e);

        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request"+e);
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
        }
    }

    public static void main(String [] args){

    }

}
