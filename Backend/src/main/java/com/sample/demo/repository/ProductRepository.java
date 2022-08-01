package com.sample.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.demo.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCategory(String cat);
	public List<Product> findTop10ByColor(String color);
    public List<Product> findByGender(String gen);
    public List<Product> findBySellerId(int id);
    public List<Product> findBySize(String size);
    public Product findByProductId(int id);
    public List<Product> findByPriceLessThanEqual(double price);
    
    @Modifying
    @Query(value="update product set price = :newPrice where productid = :id", nativeQuery = true)
    public int updatePrice(@Param("id") final int id, @Param("newPrice") final double newPrice);
	public List<Product> findByProductName(String name);
	public List<Product> findByProductNameContaining(String name);
	public List<Product> findTop10ByColorContaining(String col);
	//public List<Product> findByProductNameOrColor(String name, String col);
	public Product findTopByOrderByProductIdDesc();
    
}
