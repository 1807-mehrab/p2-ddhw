package com.rev.repo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REPLIES")
public class Reply {
	@Id
	@Column(name = "REPLYID")
	private int replyId;
	@Column(name = "TOPICID")
	private int topicId;
	@Column(name = "USERID")
	private String userId;
	@Column(name = "CONTENTID")
	private int contentId;

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", topicId=" + topicId + ", userId=" + userId + ", contentId=" + contentId
				+ "]";
	}

	public Reply(int replyId, int topicId, String userId, int contentId) {
		super();
		this.replyId = replyId;
		this.topicId = topicId;
		this.userId = userId;
		this.contentId = contentId;
	}

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

}
