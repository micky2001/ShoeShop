package com.sample.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.demo.entity.OrderDetails;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	
	public OrderDetails findByOrderId(int id);
    
    public OrderDetails findTopByOrderByOrderIdDesc();
    
    public List<OrderDetails> findAllByCustomerId(int id);
    
    
    @Modifying
    @Query(value = "update orderdetails set orderstatus = :status where orderid = :id", nativeQuery=true)
    public int updateStatus(@Param("status") String status, @Param("id") int id);
    
    
	
}
