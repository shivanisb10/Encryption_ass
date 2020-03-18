package com.psl.MyApp.DAO;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.psl.MyApp.model.Category;
import com.psl.MyApp.model.Products;

public interface ProductDAO extends CrudRepository<Products, String>{
	@Query(value="select * from Products p where p.category=?1 and quantity>0", nativeQuery=true)
	public List<Products> getProductsByCategory(Category category);
	
	@Query(value="select * from Products p where p.productid=?1", nativeQuery=true)
	public Products getProductsById(String productid);
	
	
}
