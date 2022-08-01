package com.sample.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.OrderDetails;
import com.sample.demo.entity.Product;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.ProductRepository;

@CrossOrigin(origins="http://localhost:4302")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/products")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    
	
	@GetMapping("/products/category/{cat}")
    public List<Product> findProductByCategory(@PathVariable String cat) {
        return productRepository.findByCategory(cat);
    }
	
	@GetMapping("/products/search/{name}")
    public List<Product> findProductByName(@PathVariable String name) {
        return productRepository.findByProductNameContaining(name);
    }
	
	@GetMapping("/products/color/{col}")
    public List<Product> findProductByColor(@PathVariable String col) {
        return productRepository.findTop10ByColorContaining(col);
    }
	
	@GetMapping("/products/gender/{gen}")
    public List<Product> findProductByGender(@PathVariable String gen) {
        return productRepository.findByGender(gen);
    }
	
	@GetMapping("/products/seller/{id}")
    public List<Product> findProductBySellerId(@PathVariable int id) {
        return productRepository.findBySellerId(id);
    }
	
	@GetMapping("/products/size/{size}")
    public List<Product> findProductBySize(@PathVariable String size) {
        return productRepository.findBySize(size);
    }
	
	@GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id) throws ResourceNotFoundException {
        Product p = productRepository.findByProductId(id);
        if(p == null) {
            throw new ResourceNotFoundException("Product Not Found. Please contact the admin");
        }
        
        return ResponseEntity.ok().body(p);
    }
	
	@GetMapping("/products/price/{price}")
    public List<Product> findProductByPrice(@PathVariable double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }
	
	@PutMapping("/products/update/{id}/{price}")
    @Transactional
    public ResponseEntity<String> updateProductPrice(@PathVariable int id, @PathVariable double price) throws ResourceNotFoundException {
        Product p = productRepository.findByProductId(id);
        
        String msg = "Update Unsuccessful";
        
        if (p == null) {
            throw new ResourceNotFoundException("product not found");
        }
        
        int res = productRepository.updatePrice(id, price);
        if (res > 0) {
            msg = "Successfully updated price for book id: " + p.getProductId();
        }
        
        return ResponseEntity.ok().body(msg);
    }
	
	 @PostMapping("/products")
	    public ResponseEntity<Product> saveBookDetails(@RequestBody Product product) {
	        Product b = productRepository.findTopByOrderByProductIdDesc();
	                
	        int id = 1001;
	        
	        if(b != null) {
	            id = b.getProductId() + 1;
	        }
	        
	        product.setProductId(id);
	        
	        productRepository.save(product);
	        return ResponseEntity.ok().body(product);
	    }

}
