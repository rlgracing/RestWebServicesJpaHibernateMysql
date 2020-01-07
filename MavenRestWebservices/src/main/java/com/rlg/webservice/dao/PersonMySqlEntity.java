package com.rlg.webservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class PersonMySqlEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="address")
	private String address;
	
	public PersonMySqlEntity() {
	}

	public PersonMySqlEntity(Integer id, String fullName, String address) {
		this.id = id;
		this.fullName = fullName;
		this.address = address;
	}

	public PersonMySqlEntity(String fullName, String address) {
		this.fullName = fullName;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
