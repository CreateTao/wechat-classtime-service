package com.daliu.classtime.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feed_back")
public class FeedBackDoMain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedId;
	
	//反馈人ID
	private String openId;
	
	//联系方式
	private String contact;
	
	//反馈内容，表内类型为varchar
	private String content;
	
	//反馈时间
	private String createTime;
	
	public void setFeedId(Integer feedId) {
		this.feedId = feedId;
	}
	
	public Integer getFeedId() {
		return feedId;
	}
	
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	public String getOpenId() {
		return openId;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FeedBackDoMain [feedId=" + feedId + ", openId=" + openId + ", contact="+
				contact+", content="+ content + ", createTime=" + createTime+ "]";
	}
}

