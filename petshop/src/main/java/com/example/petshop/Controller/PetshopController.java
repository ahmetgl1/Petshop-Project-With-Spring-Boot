package com.example.petshop.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.petshop.Business.abstracts.IPetShopServices;
import com.example.petshop.Business.exception.OwnerNotFoundException;
import com.example.petshop.Entity.concretes.Owners;

@RestController
@RequestMapping("/rest")
public class PetshopController {

	@Autowired
	private IPetShopServices iPetShopServices;
	
	
	@RequestMapping(method = RequestMethod.GET , value ="/owners")
	public ResponseEntity<List<Owners>> getOwners(){
		
		
		List<Owners> owners = iPetShopServices.findOwners();
	
		
		return ResponseEntity.ok(owners);
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/ownersm")
	public ResponseEntity<List<Owners>> getOwners(@RequestParam("ln") String lastName){
		
		List<Owners> owners = 	iPetShopServices.findOwners(lastName);
		
		return ResponseEntity.ok(owners);
		
	}
	
	
	
	public ResponseEntity<URI> createOwner( @RequestBody Owners owner ){
		try {
			
			iPetShopServices.create(owner);
			Long id = owner.getId();
			URI location  =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
			
		} catch (Exception e) {
                  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
		
	
		return null;
		
	}
	
	public ResponseEntity<?> updateOwner(@PathVariable("id") Long id,  @RequestBody Owners ownerRequest){
		
		
		try {
			Owners owner = iPetShopServices.findOwners(id);
			owner.setFirstName(ownerRequest.getFirstName());
			owner.setLastName(ownerRequest.getLastName());
			iPetShopServices.update(owner);

			return ResponseEntity.ok().build();
			
			
		} catch (OwnerNotFoundException e) {
               return ResponseEntity.notFound().build();
               }
		catch (Exception e) {
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
}
		
		
	}
	 
	
	
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/owner/{id}")
	public ResponseEntity<Owners> getOwner(@PathVariable("id")Long id){
		
		
		try {
			
			Owners owner = iPetShopServices.findOwners(id);
			
			return ResponseEntity.ok(owner);
			
		} catch (OwnerNotFoundException ex) {
			return ResponseEntity.notFound().build();		
	}
	
	
	
	}
	}
