package com.daliu.classtime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daliu.classtime.dao.ReplyDao;
import com.daliu.classtime.domain.ReplyDoMain;
import com.daliu.classtime.service.inservice.InReplyService;

@Service
public class ReplyServiceimp implements InReplyService{
	
	@Autowired
	private ReplyDao replyDao;
	
	public Page<ReplyDoMain> findAll(Pageable pageable){
		//查询我的记录
        Page<ReplyDoMain> pages=null;
        try{
        	pages=replyDao.findAll(pageable);
        	return pages;
        }catch(Exception e){
        	System.out.println("TimeServiceimp  findByOpenId---"+e);
        	throw e;
        }
	}
	
	@Transactional
	public List<ReplyDoMain> queryAllReply() {
		List<ReplyDoMain> list = null;
		try {
			list = replyDao.findAll();
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
	public void saveReply(ReplyDoMain replyDoMain) {
		try {
			replyDao.saveAndFlush(replyDoMain);
		} catch (Exception e) {
			throw e;
		}
	}

}

