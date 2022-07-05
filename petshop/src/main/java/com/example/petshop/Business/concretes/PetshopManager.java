package com.example.petshop.Business.concretes;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshop.Business.abstracts.IPetShopServices;
import com.example.petshop.Business.exception.OwnerNotFoundException;
import com.example.petshop.DataAccess.abstracts.IOwnersDAO;
import com.example.petshop.DataAccess.abstracts.IPetsDAO;
import com.example.petshop.DataAccess.concretes.OwnersRepository;
import com.example.petshop.Entity.concretes.Owners;

@Service
public class PetshopManager implements IPetShopServices {
	
	
	private IOwnersDAO iownersdao;


	@Autowired
	public void setIownersdao(IOwnersDAO iownersdao) {
		this.iownersdao = iownersdao;
	}


	@Override
	public List<Owners> findOwners() {
		
		return iownersdao.findAll();
	}


	@Override
	public List<Owners> findOwners(String lastName) {
		
		return iownersdao.findByLastName(lastName);
	}


	@Override
	public Owners findOwners(Long id) throws OwnerNotFoundException {
	 Owners owner = iownersdao.findById(id);
	 if(owner == null) throw new  OwnerNotFoundException("Owner is not found !");
	 
	 
	 return  owner;
	}
	
	


	@Override
	public void create(Owners owner) {
		iownersdao.create(owner);
	}


	@Override
	public void update(Owners owner) {
		
		iownersdao.update(owner);
		
	}


	@Override
	public void deleteOwner(Long id) {
		
	iownersdao.delete(id);	
		
		
		
		
		
	}

   
	
	
	
	

}
