package com.example.todo.domain;

public class ToDoBuilder {
	public static  ToDoBuilder instance = new ToDoBuilder();
	private String id=null;
	private String description="";
	
	public ToDoBuilder(){}
	public ToDoBuilder create() {
		return instance;
	}
	
	public ToDoBuilder withDescription(String description){
		this.description = description;
		return instance;
	}
	public ToDoBuilder withId(String id){
		this.id = id;
		return instance;
	}
	public ToDo build(){
		ToDo result = new ToDo(this.description);
		if(id != null)
		    result.setId(id);
		return result;
	}

}
