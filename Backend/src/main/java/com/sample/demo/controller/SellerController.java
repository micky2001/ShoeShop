package com.sample.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.Seller;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.SellerRepository;

@RestController
@RequestMapping("/api")
public class SellerController {
	@Autowired
	private SellerRepository sellerRepository;
	
	
	@PostMapping("/seller")
    public Seller addNewSeller(@RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }
	
	@GetMapping("/seller/email/{email}")
    public ResponseEntity<Seller> findSellerByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
        Seller s = sellerRepository.findBysemail(email);
        
        if(s == null) {
            throw new ResourceNotFoundException("Seller Not Found. Please contact the admin");
        }
        
        return ResponseEntity.ok().body(s);
    }
    
    @GetMapping("/seller/{id}")
    public ResponseEntity<Seller> findSellerById(@PathVariable("id") int id) throws ResourceNotFoundException {
        Seller s = sellerRepository.findBySellerId(id);
        
        if(s == null) {
            throw new ResourceNotFoundException("Seller Not Found. Please contact the admin");
        }
        
        return ResponseEntity.ok().body(s);
    }
    
   
}
