package com.daliu.classtime.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daliu.classtime.domain.FeedBackDoMain;


public interface FeedBackDao extends JpaRepository<FeedBackDoMain, Integer>{
	
	//分页查询
	public Page<FeedBackDoMain> findAll(Pageable pageable);
	
	/*根据OpneId查询
	public List<FeedBackDoMain> findByOpenId(String openId);*/
	
}