package com.daliu.classtime.control;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.daliu.classtime.domain.ReplyDoMain;
import com.daliu.classtime.service.ReplyServiceimp;
import com.daliu.classtime.utils.ErrorMsg;


@RestController
@RequestMapping("/classtime/reply")
public class ReplyControl {
	
	private static Logger logger = LogManager.getLogger("control.reply");
	
	static String log="\r\n****************      纪录结束       **********************\r\n";
	
	@Autowired
	private ReplyServiceimp replyServiceimp;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		return "这是反馈";
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<ReplyDoMain> getAll(){
		return replyServiceimp.queryAllReply();
	}
	
	@RequestMapping(value="/getpage",method=RequestMethod.POST)
	public Page<ReplyDoMain> getPage(@RequestParam int pageNum){
		try {
			//System.out.println(pageNum);
	
			Sort sort = new Sort(Sort.Direction.ASC, "replyId");
			Pageable pageable = PageRequest.of(pageNum,10, sort);
			//PageRequest.of(当前查询的是第几页，每页展示多少条数据，sort参数)
			Page<ReplyDoMain> pages=replyServiceimp.findAll(pageable);
			//System.out.println(pages.getTotalElements()+"---"+pages.getTotalPages());
			return pages; 
		} catch (Exception e) {
			System.out.println("ReplyControl have error\n");
			ErrorMsg msg=new ErrorMsg();
			logger.error("*********查询页数："+pageNum+
					"     错误原因\r\n"+msg.getStackTrace(e)+log);
			return null;
		}
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody ReplyDoMain replyDoMain) {
		try {
			System.out.println("-------------"+replyDoMain.getContent());
			replyServiceimp.saveReply(replyDoMain);
			return "成功";
		} catch (Exception e) {
			System.out.println("保存 have error\n");
			ErrorMsg msg=new ErrorMsg();
			logger.error("*********反馈人id："+replyDoMain.getOpenId()+
					"     错误原因\r\n"+msg.getStackTrace(e)+log);
			return null;
		}
		
	}
}
