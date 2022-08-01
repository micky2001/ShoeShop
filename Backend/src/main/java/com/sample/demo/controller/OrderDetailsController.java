package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.OrderDetails;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.OrderDetailsRepository;

@CrossOrigin(origins="http://localhost:4302")
@RestController
@RequestMapping("/api")
public class OrderDetailsController {
	@Autowired
	private OrderDetailsRepository orderRepository;
	
	
	@GetMapping("/order/{id}")
    public ResponseEntity<OrderDetails> findOrderById(@PathVariable int id) throws ResourceNotFoundException {
        OrderDetails p = orderRepository.findByOrderId(id);
        
        if (p == null) {
            throw new ResourceNotFoundException("Order Details not found");
        }
        
        return ResponseEntity.ok().body(p);
    }
    

    
    @GetMapping("/order/customer/{id}")
    public List<OrderDetails> findAllMemberPurchases(@PathVariable int id) {
        return orderRepository.findAllByCustomerId(id);
    }
    
    
    @PostMapping("/order")
    public ResponseEntity<OrderDetails> savePurchaseDetails(@RequestBody OrderDetails purchase) {
    	OrderDetails p = orderRepository.findTopByOrderByOrderIdDesc();
        
        int id = 101;
        
        if (p != null) {
            id = p.getOrderId() + 1;
        }
        
        purchase.setOrderId(id);
        orderRepository.save(purchase);
        
        return ResponseEntity.ok().body(purchase);
    }
    

}
