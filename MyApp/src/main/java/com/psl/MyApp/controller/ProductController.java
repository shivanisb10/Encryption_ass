package com.psl.MyApp.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.MyApp.ExceptionHandler.ProductNotFoundException;
import com.psl.MyApp.model.Category;
import com.psl.MyApp.model.Products;
import com.psl.MyApp.service.CartService;
import com.psl.MyApp.service.ProductService;

@RestController
//@EnableWebSecurity
@RequestMapping("/product")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductService ps;
	@Autowired
	CartService cs;
	@GetMapping
	public ResponseEntity<List<Products>> getProducts()
	{  System.out.println("hi");
		List<Products> p=(List<Products>)ps.getProducts();
	if(p.isEmpty())
		throw new ProductNotFoundException();
	else
		return new ResponseEntity<List<Products>>(p,HttpStatus.OK);
		
		
	}
	@GetMapping("/{category}")
	public ResponseEntity<List<Products>>getProductsByCategory(@PathVariable Category category)
	{
		List<Products > p=(List<Products>) ps.getProductsByCategory(category);
		if(p.isEmpty())
			throw new ProductNotFoundException();
		else
			return new ResponseEntity<List<Products>>(p,HttpStatus.OK);
	}
	
	
	

}
