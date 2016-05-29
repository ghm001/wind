package com.wind.saying.service;

import com.wind.saying.dao.SayingDao;
import com.wind.saying.model.SayingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */

@Service
public class SayingServiceImpl implements SayingService{
   @Autowired
    SayingDao sayingDao;

    @Override
    public List<SayingVO> getCzwSayings() {
        return sayingDao.getCzwSayings();
    }

    @Override
    public List<SayingVO> getQzSayings() {
        return sayingDao.getQzSayings();
    }

    @Override
    public void addSaying(SayingVO sayingVO) {
        sayingDao.addSaying(sayingVO);
    }

    @Override
    public void deleteSaying(int sayingId) {
        sayingDao.deleteSaying(sayingId);
    }

    @Override
    public SayingVO getSaying(int sayingId) {
       return sayingDao.getSaying(sayingId);
    }
}
