package com.daliu.classtime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daliu.classtime.dao.FeedBackDao;
import com.daliu.classtime.domain.FeedBackDoMain;
import com.daliu.classtime.service.inservice.InFeedService;

@Service
public class FeedBackServiceimp implements InFeedService{
	
	@Autowired
	private FeedBackDao feedBackDao;
	
	public Page<FeedBackDoMain> findAll(Pageable pageable){
		//查询我的记录
        Page<FeedBackDoMain> pages=null;
        try{
        	pages=feedBackDao.findAll(pageable);
        	return pages;
        }catch(Exception e){
        	System.out.println("TimeServiceimp  findByOpenId---"+e);
        	throw e;
        }
	}
	
	@Transactional
	public List<FeedBackDoMain> queryAllFeed() {
		List<FeedBackDoMain> list = null;
		try {
			list = feedBackDao.findAll();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	@Transactional
	public List<FeedBackDoMain> findByOpenId(String openId) {
		List<FeedBackDoMain> list = null;
		try {
			list = feedBackDao.findByOpenId(openId);
			return list;
		} catch (Exception e) {
			throw e;
		}
	}*/

	
	@Transactional
	public void saveFeed(FeedBackDoMain feedBackDoMain) {
		try {
			feedBackDao.saveAndFlush(feedBackDoMain);
		} catch (Exception e) {
			throw e;
		}
	}

}

