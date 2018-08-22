package com.rev.repo.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPLIES")
public class Reply {
	@Id
	@Column(name = "REPLYID")
	private int replyId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "TOPICID")
	private Topic topic;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "USERID")
	private UserProfile user;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Column(name = "CONTENTID")
	private Resource content;

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", topicId=" + topic.getTopicId() + ", userId=" + user.getUser().getUserId() + ", contentId=" + content.getContentId()
				+ "]";
	}

	public Reply(int replyId, Topic topic, UserProfile user, Resource content) {
		super();
		this.replyId = replyId;
		this.topic = topic;
		this.user = user;
		this.content = content;
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

	public Topic getTopicId() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public UserProfile getUserId() {
		return user;
	}

	public void setUserId(UserProfile user) {
		this.user = user;
	}

	public Resource getContent() {
		return content;
	}

	public void setContent(Resource content) {
		this.content = content;
	}

}
