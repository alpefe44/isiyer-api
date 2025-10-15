package com.isiyer.isiyer.webApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isiyer.isiyer.business.abstracts.ProductService;
import com.isiyer.isiyer.business.requests.CreateProductRequest;
import com.isiyer.isiyer.business.requests.UpdateProductRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductsController {
	private final ProductService productService;

	
	@PostMapping("/yards/{yardId}/products")
	public ResponseEntity<Void> addProduct(@PathVariable int yardId , @RequestBody CreateProductRequest dto ) {
		productService.add(yardId, dto);
		return ResponseEntity.ok().build();
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody UpdateProductRequest request) {
	        this.productService.update(id, request);
	        return ResponseEntity.ok().build();
	    }
}
