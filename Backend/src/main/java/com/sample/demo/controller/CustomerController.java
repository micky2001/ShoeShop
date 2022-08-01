package com.sample.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.Customer;
import com.sample.demo.entity.Product;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.CustomerRepository;

@CrossOrigin(origins="http://localhost:4302")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer cust) {
        return customerRepository.save(cust);
    }
    
	@GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
	
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") int id) throws ResourceNotFoundException {
        Customer c = customerRepository.findByCustomerId(id);
        if (c == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        return ResponseEntity.ok().body(c);
    }
    
    @GetMapping("/customers/em/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable(value="email") String email) throws ResourceNotFoundException {
        Customer c = customerRepository.findByCustEmail(email);
        
        if (c == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        return ResponseEntity.ok().body(c);
    }
    
    @GetMapping("/customers/top")
    public ResponseEntity<Customer> getTopRecord() {
        Customer c = customerRepository.findTopByOrderByCustomerIdDesc();
        return ResponseEntity.ok().body(c);
    }
    
    
    @PutMapping("/customers/wallet/{id}/{bal}")
    @Transactional
    public ResponseEntity<String> updateWalletBalance(@PathVariable(value="id")int id, @PathVariable(value="bal") double bal) throws ResourceNotFoundException {
    	Customer c = customerRepository.findByCustomerId(id);
        
        String msg = "Update Unsuccessful";
        
        if (c == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        
        int res = customerRepository.updateWalletBalance(id, bal);
        if (res > 0) {
            msg = "Successfully updated wallet updated for customer id: " + c.getCustomerId();
        }
        
        return ResponseEntity.ok().body(msg);
    }
   
    
    
}
