package com.brasajava.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private long id;
    @NotNull
    @Size(min=2, max=60)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;
    @Valid
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Contact> contacts;
    
    public Person(){
    	contacts = new ArrayList<>();
    }

    public Long getId(){
    	return id;
    }
    public void setId(Long id){
    	this.id = id;
    }
    public String getName() {
        return this.name;
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

    public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String toString() {
        return "Person(Id: " + id + ", Name: " + this.name + ", Age: " + this.age + " Contacts: " + contacts +")";
    }
}
