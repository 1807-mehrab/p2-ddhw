package com.rev.repo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOPIC")
public class Topic {
	@Id
	@Column(name = "TOPICID")
	private int topicId;
	@Column(name = "USERID")
	private String userId;
	@Column(name = "CONTENTID")
	private int contentId;
	@Column(name = "TOPICLINE")
	private String topicLine;

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", userId=" + userId + ", contentId=" + contentId + ", topicLine="
				+ topicLine + "]";
	}

	public Topic(int topicId, String userId, int contentId, String topicLine) {
		super();
		this.topicId = topicId;
		this.userId = userId;
		this.contentId = contentId;
		this.topicLine = topicLine;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getTopicLine() {
		return topicLine;
	}

	public void setTopicLine(String topicLine) {
		this.topicLine = topicLine;
	}

	
}
