package com.wind.user.dao;

import com.wind.saying.model.SayingVO;
import com.wind.saying.service.SayingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class SayingDaoTest {
    @Autowired
    SayingService sayingService;


    //测试车周围信息
    @Test
    public void getCzwSayings(){
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getCzwSayings();
        System.out.println(list.get(0).getSayingId());
    }

    //测试求助信息
    @Test
    public void getQzSayings(){
        List<SayingVO> list=new ArrayList<SayingVO>();
        list=sayingService.getQzSayings();
        System.out.println(list.get(0).getSayingId());
    }

    //添加一条说说
    @Test
    public void addSaying(){
        SayingVO sayingVO=new SayingVO();
        sayingVO.setUserId(1);
        sayingService.addSaying(sayingVO);
    }

    //删除一条说说
    @Test
    public void delateSaying(){
        int sayingId=5;
        sayingService.deleteSaying(sayingId);
    }

    //获得一条说说
    @Test
    public void getSaying(){
        int sayingId=1;
        SayingVO sayingVO=new SayingVO();
        sayingVO=sayingService.getSaying(sayingId);
        System.out.println(sayingVO.getImg2());
    }

}
