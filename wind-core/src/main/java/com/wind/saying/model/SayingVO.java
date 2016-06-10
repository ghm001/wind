package com.wind.saying.model;

import java.util.Date;

/**
 * 所有的悲伤都由自己去承担。
 * 努力永远都不会错。
 * Created by Qiuyong on 2016/5/3.
 */

/**
 * 与说说相关的实体类
 */
public class SayingVO {
    private int sayingId;//说说id号
    private int userId;//用户id号
    private String nickName;//用户昵称
    private String userIconUrl;//用户头像指定地址
    private String strTime;//发表说说时间
    private Date postTime;//发表说说时间
    private String sayingContent;//发表说说的内容
    private String postAddress;//发表说说时的地址
    private int sayingType;//发表说说类型
    private String img1;//发表说说图片1
    private String img2;//发表说说图片2
    private String img3;//发表说说图片3
    private String img4;//发表说说图片4
    private String img5;//发表说说图片5
    private String img6;//发表说说图片6

    public SayingVO() {

    }

    public SayingVO(int userId, Date postTime, String strTime, String sayingContent, String postAddress, int sayingType, String img1, String img2, String img3, String img4, String img5, String img6) {
        this.userId = userId;
        this.postTime = postTime;
        this.sayingContent = sayingContent;
        this.postAddress = postAddress;
        this.sayingType = sayingType;
        this.strTime = strTime;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.img5 = img5;
        this.img6 = img6;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public int getSayingId() {
        return sayingId;
    }

    public void setSayingId(int sayingId) {
        this.sayingId = sayingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getSayingContent() {
        return sayingContent;
    }

    public void setSayingContent(String sayingContent) {
        this.sayingContent = sayingContent;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public int getSayingType() {
        return sayingType;
    }

    public void setSayingType(int sayingType) {
        this.sayingType = sayingType;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }


}
