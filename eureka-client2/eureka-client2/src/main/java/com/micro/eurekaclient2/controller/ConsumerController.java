package com.micro.eurekaclient2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.eurekaclient1.model.Product;
import com.micro.eurekaclient2.feign.ProductFeign;


@RestController
@RequestMapping("/orders")
public class ConsumerController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	ProductFeign productFeign;
	
	

//	@GetMapping("/")
//	public String welcomeToPage() {
//		return "HABIBI WELCOME TO MICROSERVICE";
//	}
	
	@GetMapping("/{orderId}")
    public String getOrderDetails(@PathVariable Long orderId) {
		
		
		Integer productId = 1;
//        Product product = restTemplate.getForObject("http://service1:8090/products/" + productId, Product.class);
        
        Product product = productFeign.getProduct(1L);
        
        return "Order #" + orderId + " - Product: " + product.getName() + ", Price: " + product.getPrice();
		
    }


}
