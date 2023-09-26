package com.fkssm02.ch04;

public class Person {
	Integer id;
	String name;
	Integer age;
	
	
	public Person() {
		super();
		System.out.println(this.getClass().getName()+" created ...");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	

}
