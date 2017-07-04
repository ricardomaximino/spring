package com.brasajava.business.registration;

public class Person {
	
	private long id;
	private String name;
	private String lastname;
	
	public Person(){
		
	}
	
	public Person(long id, String name, String lastname){
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}
}
