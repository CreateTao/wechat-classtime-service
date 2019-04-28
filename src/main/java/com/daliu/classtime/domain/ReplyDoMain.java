package com.daliu.classtime.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class ReplyDoMain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer replyId;
	
	//反馈人ID
	private String openId;
	
	//联系方式
	private String contact;
	
	
	//反馈内容，表内类型为varchar
	private String content;
	
	//反馈类型
	private String checkBoxValue;
	
	//反馈评级
	private int stars;
	
	//反馈时间
	private String createTime;
	
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	
	public Integer getReplyId() {
		return replyId;
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
	
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public int getStars() {
		return stars;
	}
	
	public void setCheckBoxValue(String checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}
	
	public String getCheckBoxValue() {
		return checkBoxValue;
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
		return "ReplyDoMain [replyId=" + replyId + ", openId=" + openId + ", contact="+
				contact+", content="+ content + ", createTime=" + createTime+ "]";
	}
}

