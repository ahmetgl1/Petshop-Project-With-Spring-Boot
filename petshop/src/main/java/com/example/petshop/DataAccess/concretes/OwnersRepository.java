package com.example.petshop.DataAccess.concretes;

			import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.petshop.DataAccess.abstracts.IOwnersDAO;
import com.example.petshop.Entity.concretes.Owners;


@Repository
public class OwnersRepository implements IOwnersDAO {
	
	private Map<Long, Owners> ownersMap = new HashMap<>();
	
	
	
	public OwnersRepository() {

		
		Owners owner1 = new Owners();
		owner1.setId(1L);
		owner1.setFirstName("Ahmet");
		owner1.setLastName("Güzeller");
		
		Owners owner2 = new Owners();
		owner2.setId(2L);
		owner2.setFirstName("Yusuf");
		owner2.setLastName("Güzeller");
		
		
		
		Owners owner3 = new Owners();
		owner3.setId(3L);
		owner3.setFirstName("Yusuf");
		owner3.setLastName("Güzeller");
		
		
		ownersMap.put(owner1.getId(), owner1);
		ownersMap.put(owner2.getId(), owner2);
		ownersMap.put(owner3.getId(), owner3);
		
		
		
		
	}
	

	@Override
	public List<Owners> findAll() {
		// TODO Auto-generated method stub
		return  new ArrayList<>(ownersMap.values());
	}

	@Override
	public Owners findById(Long id) {
		
		return ownersMap.get(id);
	}

	@Override
	public List<Owners> findByLastName(String lastName) {
	
		return ownersMap.values().stream().filter(o -> o.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Owners owner) {
		owner.setId(new Date().getTime());
		ownersMap.put(owner.getId(), owner);
		
	}

	@Override
	public Owners update(Owners owner) {
		
		 ownersMap.replace(owner.getId(), owner);
				
		return owner;
	}

	@Override
	public void delete(Long id) {
		
		ownersMap.remove(id);
		
		
		
	}

}
