package com.sample.demo.controller;



//import javax.transaction.Transactional;

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

import com.sample.demo.entity.Users;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.UsersRepository;

@CrossOrigin(origins="http://localhost:4302")
@RestController
@RequestMapping("/api")
public class UsersController {
	@Autowired
	private UsersRepository userRepository;
	
	@GetMapping("/ping")
    public String healthCheck() {
        return "All Ok.";
    }
	@GetMapping("/users/{id}")
    public ResponseEntity<Users> getMemberById(@PathVariable(value="id") int id) {
        Users u = userRepository.findByUserId(id);
        return ResponseEntity.ok().body(u);
    }
	
	@PostMapping("/users")
    public Users addStudent(@RequestBody Users user) {
        return userRepository.save(user);
    }
	
    
   
	
}
