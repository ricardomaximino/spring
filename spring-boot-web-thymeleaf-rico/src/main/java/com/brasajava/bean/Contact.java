package com.brasajava.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=2,max=20)
	@Column(name="description")
	private String contactDescription;
	
	@NotNull
	@Size(min=9,max=60)
	private String contactValue;
	
	public Contact(){}
	
	public Contact(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getContactDescription() {
		return contactDescription;
	}
	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}
	public String getContactValue() {
		return contactValue;
	}
	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactDescription=" + contactDescription + ", contact=" + contactValue + "]";
	}
	
}
