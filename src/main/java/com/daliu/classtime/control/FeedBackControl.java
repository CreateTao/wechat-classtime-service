package com.daliu.classtime.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daliu.classtime.domain.FeedBackDoMain;
import com.daliu.classtime.service.FeedBackServiceimp;


@RestController
@RequestMapping("/classtime/feedback")
public class FeedBackControl {
	
	@Autowired
	private FeedBackServiceimp feedBackServiceimp;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		return "这是反馈";
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<FeedBackDoMain> getAll(){
		return feedBackServiceimp.queryAllFeed();
	}
	
	@RequestMapping(value="getPage",method=RequestMethod.GET)
	public Page<FeedBackDoMain> getPage(@RequestParam int pageNum){
		try {
			//System.out.println(pageNum);
			
			Sort sort = new Sort(Sort.Direction.DESC, "feedId");
			Pageable pageable = PageRequest.of(pageNum,10, sort);
			//PageRequest.of(当前查询的是第几页，每页展示多少条数据，sort参数)
			Page<FeedBackDoMain> pages=feedBackServiceimp.findAll(pageable);
			//System.out.println(pages.getTotalElements()+"---"+pages.getTotalPages());
			return pages; 
		} catch (Exception e) {
			System.out.println("UserControl myRecord have error\n");
			return null;
		}
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody FeedBackDoMain feedBackDoMain) {
		System.out.println("-------------"+feedBackDoMain.getContent());
		feedBackServiceimp.saveFeed(feedBackDoMain);
		return "成功";
	}
}
