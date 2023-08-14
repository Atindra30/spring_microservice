package com.micro.eurekaclient1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.eurekaclient1.model.Product;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId) {
		System.out.println(environment.getProperty("local.server.port"));
		
		
        // Fetch the product data from a database or some data source
        // For simplicity, let's create a dummy product
        return new Product(productId, "Sample Product", 19.99);
    }

}
