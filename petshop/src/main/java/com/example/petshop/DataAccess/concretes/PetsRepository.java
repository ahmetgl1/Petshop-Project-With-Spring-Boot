package com.example.petshop.DataAccess.concretes;

import java.util.List;

import com.example.petshop.DataAccess.abstracts.IPetsDAO;
import com.example.petshop.Entity.concretes.Pets;

public class PetsRepository implements IPetsDAO {

	@Override
	public Pets findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pets> findByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Pets pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pets update(Pets pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pets id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByOwnerId(Long id) {
		// TODO Auto-generated method stub
		
	}

}
