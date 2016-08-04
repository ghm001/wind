package com.wind.user.dao;

import com.wind.saying.model.SayingVO;
import com.wind.saying.service.SayingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class SayingDaoTest {
    @Autowired
    SayingService sayingService;

    //查询车周围信息
    @Test
    public void getCzwSayings() {
        List<SayingVO> list = new ArrayList<SayingVO>();
        list = sayingService.getCzwSayings();
        System.out.println(list.size());
    }

    //测试求助信息
    @Test
    public void getQzSayings() {
        List<SayingVO> list = new ArrayList<SayingVO>();
        list = sayingService.getQzSayings();
        System.out.println(list.get(0).getSayingId());
    }

    //添加一条说说
    @Test
    public void addSaying() {
        SayingVO sayingVO = new SayingVO();
        sayingVO.setUserId(1);//指定用户id号
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = format.format(date);
        sayingVO.setStrTime(strTime);//说说添加的时间
        sayingVO.setPostTime(date);
        sayingVO.setSayingContent("大家好，我叫莱奥.罗纳尔多，我擅长左右脚。 今天独中五元，简直是太棒了，分享一下我的进球图。");
        sayingVO.setPostAddress("吉林省长春市朝阳区延安大街2055号");
        sayingVO.setSayingType(1);
        sayingService.addSaying(sayingVO);
    }

    //删除一条说说
    @Test
    public void delateSaying() {
        int sayingId = 78;
        sayingService.deleteSaying(sayingId);
    }

    //获得某一条说说
    @Test
    public void getSaying() {
        int sayingId = 156;
        SayingVO sayingVO = new SayingVO();
        sayingVO = sayingService.getSaying(sayingId);
        System.out.println("用户id号：" + sayingVO.getUserId());
        System.out.println("说说内容：" + sayingVO.getSayingContent());
        System.out.println("发表地点：" + sayingVO.getPostAddress());
        System.out.println("发表时间：" + sayingVO.getStrTime());
        System.out.println("说说类型：" + sayingVO.getSayingType());
        System.out.println("图片1地址：" + sayingVO.getImg1());
        System.out.println("图片2地址：" + sayingVO.getImg2());
        System.out.println("图片3地址：" + sayingVO.getImg3());
        System.out.println("图片4地址：" + sayingVO.getImg4());
        System.out.println("图片5地址：" + sayingVO.getImg5());
        System.out.println("图片6地址：" + sayingVO.getImg6());
    }

}
