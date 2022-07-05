package com.example.petshop.Business.abstracts;
import java.util.List;

import com.example.petshop.Business.exception.OwnerNotFoundException;
import com.example.petshop.Entity.concretes.Owners;


public interface IPetShopServices {

	
	List<Owners> findOwners();
	List<Owners> findOwners(String lastName);
	Owners findOwners(Long id) throws OwnerNotFoundException;
	void create(Owners owner);
	void update(Owners owner);
	void deleteOwner(Long id);
	
	
	
	
	
	
	
}
