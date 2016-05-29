package com.wind.saying.service;


import com.wind.saying.model.SayingVO;

import java.util.List;

public interface SayingService {
    //查询车周围的信息
    public List<SayingVO> getCzwSayings();

    //查询求助信息
    public List<SayingVO> getQzSayings();

    //添加路周围的
    public void addSaying(SayingVO sayingVO);

    //删除某一条说说
    public void  deleteSaying(int sayingId);

    //得到某一条说说
    public SayingVO getSaying(int sayingId);
}
