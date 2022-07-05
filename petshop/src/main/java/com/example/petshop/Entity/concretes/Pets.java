package com.example.petshop.Entity.concretes;

import java.util.Date;

import com.example.petshop.Entity.abstracts.IEntity;

public class Pets implements IEntity{
	
	
	
	
	private Long id;
	private String name;
	private Owners owner;
	private Date birthday;
	
	
	public Pets() {
	
	}


	public Pets(Long id, String name, Owners owner, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.birthday = birthday;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Owners getOwner() {
		return owner;
	}


	public void setOwner(Owners owner) {
		this.owner = owner;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
	
	
	
	
	
	
}
