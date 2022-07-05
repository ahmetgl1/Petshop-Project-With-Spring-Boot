package com.example.petshop.DataAccess.abstracts;

import com.example.petshop.Entity.concretes.Pets;
import java.util.ArrayList;
import java.util.List;


public interface IPetsDAO {

	
	Pets findById(Long id);
	List<Pets> findByOwnerId(Long ownerId);
	void create(Pets pet);
	Pets update(Pets pet);
	void delete(Pets id);
	void deleteByOwnerId(Long id);
	
	
	
	
	
	
}
