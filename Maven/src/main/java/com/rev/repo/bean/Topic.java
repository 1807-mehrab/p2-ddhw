package com.rev.repo.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TOPIC")
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "topicSeq")
	@SequenceGenerator(allocationSize=1, name="topicSeq", sequenceName = "PK_Topic_SEQ")
	@Column(name = "TOPICID")
	private int topicId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "USERID")
	private UserProfile user;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Column(name = "CONTENTID")
	private Resource content;
	
	@Column(name = "TOPICLINE")
	private String topicLine;
	
	@Column(name = "TOPICFLAG")
	private int flag;

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", userId=" + user.getUser() + ", contentId=" + content.getContentId() + ", topicLine="
				+ topicLine + "]";
	}

	public Topic(int topicId, UserProfile user, Resource content, String topicLine, int flag) {
		super();
		this.topicId = topicId;
		this.user = user;
		this.content = content;
		this.topicLine = topicLine;
		this.flag = flag;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isFlagged() {
		return flag > 0;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public Resource getContent() {
		return content;
	}

	public void setContent(Resource content) {
		this.content = content;
	}

	public String getTopicLine() {
		return topicLine;
	}

	public void setTopicLine(String topicLine) {
		this.topicLine = topicLine;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
