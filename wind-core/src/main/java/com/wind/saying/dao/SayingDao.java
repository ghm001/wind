package com.wind.saying.dao;

import com.wind.saying.model.SayingVO;
import com.wind.utils.annotation.mybatis.MyBatisScan;

import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */

@MyBatisScan
public interface SayingDao {
    //查询车周围信息
    public List<SayingVO> getCzwSayings();

    //查询求助信息
    public List<SayingVO> getQzSayings();

    //添加路周围的
    public void addSaying(SayingVO sayingVO);

    //删除某一条说说
    public void deleteSaying(int sayingId);

    //得到某一条说说
    public SayingVO getSaying(int sayingId);
}
