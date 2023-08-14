package com.micro.eurekaclient2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.eurekaclient1.model.Product;



@FeignClient("SERVICE1")
public interface ProductFeign {
	@GetMapping("products/{productId}")
    public Product getProduct(@PathVariable Long productId);
	

}
