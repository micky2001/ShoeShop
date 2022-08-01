package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.demo.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByCustEmail(String email);
    public Customer findByCustomerId(int id);
    
    
    @Modifying
    @Query(value="update customer set walletBalance = :bal where customerid = :id", nativeQuery=true)
    public int updateWalletBalance(@Param("id")final int id, @Param("bal") final double bal);
	
    public Customer findTopByOrderByCustomerIdDesc();
    
}
