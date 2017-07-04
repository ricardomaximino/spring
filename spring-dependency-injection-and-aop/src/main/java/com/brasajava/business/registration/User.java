package com.brasajava.business.registration;

public class User implements Authenticable{
	
	private long id;
	private String username;
	private String password;
	private Person person;
	private Address address;

	public User(){
		
	}
	
	public User(long id, String username,String password,Person person,Address address){
		this.id = id;
		this.username = username;
		this.password = password;
		this.person = person;
		this.address = address;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean login(String username, String password) {
		if(this.username != null && this.password != null){
			if(this.username.equals(username) && this.password.equals(password)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", person=" + person
				+ ", address=" + address + "]";
	}
}
