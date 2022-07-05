package com.example.petshop.DataAccess.abstracts;

import java.util.List;

import com.example.petshop.Entity.concretes.Owners;

public interface IOwnersDAO {
	
	List<Owners> findAll();
	Owners findById(Long id);
	List<Owners> findByLastName(String lastName);
	void create(Owners owner);
	Owners update(Owners owner);
	void delete(Long id);
	
	
	
	

}
