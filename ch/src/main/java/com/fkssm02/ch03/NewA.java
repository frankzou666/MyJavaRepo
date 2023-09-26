package com.fkssm02.ch03;

public class NewA {

	public String content_a;
	public String title_a;
	
	
	private NewA(String content_a) {
		this.content_a=content_a;
		System.out.println("default constructor with args(content_a)");
	}

	private NewA() {
		System.out.println("default constructor without args...");
	}



	@Override
	public String toString() {
		return "NewA [content_a=" + content_a + ", title_a=" + title_a + "]";
	}

}
