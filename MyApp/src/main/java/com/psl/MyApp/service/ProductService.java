package com.psl.MyApp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.MyApp.DAO.ProductDAO;
import com.psl.MyApp.ExceptionHandler.ProductNotFoundException;
import com.psl.MyApp.model.Category;
import com.psl.MyApp.model.Products;

@Service
public class ProductService {

	
	@Autowired
	ProductDAO pd;
	
	public List<Products> getProducts()
	{ 
	
		return (List<Products>)pd.findAll();
	}
	
	public List<Products> getProductsByCategory(Category category)
	{  
		return pd.getProductsByCategory(category);
	}
	public Products getProductsById(String productid)
	{
		Products ob=pd.getProductsById(productid);
		if(ob!=null)
			return ob;
		else
		throw new ProductNotFoundException();
	}
}
