package com.daliu.classtime.service.inservice;

import java.util.List;

import com.daliu.classtime.domain.FeedBackDoMain;

public interface InFeedService {
	
	public List<FeedBackDoMain> queryAllFeed();
	
	public void saveFeed(FeedBackDoMain feedBackDoMain);
	
	/*根据openId查询
	public List<FeedBackDoMain> findByOpenId(String openId);*/
	
	/*删除某人的全部反馈，不设置删除功能
	 *public void deleteByOpenId(String openId);*/
	
}
