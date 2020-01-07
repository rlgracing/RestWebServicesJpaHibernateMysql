package com.rlg.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Person {

	private String id;
	private String fullName;
	private String address;
	
	public Person() {
		
	}

	public Person(String fullName, String address) {
		this.fullName = fullName;
		this.address = address;
	}

	public Person(String id, String fullName, String address) {
		this.id = id;
		this.fullName = fullName;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
