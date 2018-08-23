package com.rev.repo.bean;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESOURCES")
public class Resource {
	@Id
	@Column(name = "CONTENTID")
	private int contentId;
	@Column(name = "TEXT")
	private String text;
	@Column(name = "IMAGE")
	private Blob image;
	@Column(name = "VIDEO")
	private String video;
	@Column(name = "DOCUMENT")
	private Blob document;

	public Resource(int contentId, String text, Blob image, String video, Blob document) {
		super();
		this.contentId = contentId;
		this.text = text;
		this.image = image;
		this.video = video;
		this.document = document;
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Blob getDocument() {
		return document;
	}

	public void setDocument(Blob document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "Resource "
				+ "{contentId=" + contentId 
				+ ", text=" + text 
				+ ", image=" + image 
				+ ", video=" + video
				+ ", document=" + document 
				+ "}";
	}
}
