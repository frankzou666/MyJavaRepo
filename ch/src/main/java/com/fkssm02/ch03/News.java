package com.fkssm02.ch03;

public class News {
	
	private Integer id;
	private String title;
	private String content;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public News(Integer id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public News() {
	}
	
	
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	

}
