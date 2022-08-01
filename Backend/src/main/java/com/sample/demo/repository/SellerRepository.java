package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.demo.entity.Seller;



@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	public Seller findBysemail(String em);
    public Seller findBySellerId(int id);
    
}
