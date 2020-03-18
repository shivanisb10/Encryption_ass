package com.psl.MyApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.MyApp.model.Cart;
import com.psl.MyApp.model.Products;
import com.psl.MyApp.service.CartService;
import com.psl.MyApp.service.ProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {
    
	@Autowired
	CartService cs;
	
	@Autowired
	ProductService ps;
	
	@RequestMapping("/price/{userid}")
	public float getTotalPrice(@PathVariable String userid)
	{
		return cs.calculatePrice(userid);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity< List<Cart>> getCartIteams( @PathVariable String userid)
	{   System.out.println("inside get cart iteams");
		List c= (List<Cart>)cs.getCartIteams(userid);
		System.out.println(c);
		System.out.println(userid);
		return new ResponseEntity<List<Cart>>(c,HttpStatus.OK);
		
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public ResponseEntity<String> addIteam(@RequestBody Cart cart)
	{ 
	//System.out.println(cart.getProductid().getProductid());
		Cart c=cs.checkCart(cart.getUserid(), cart.getProductid().getProductid());
	if (c==null)
	{ System.out.println("adding to cart");
		if(cs.addIteam(cart.getUserid(), cart.getProductid().getProductid(),cart.getQuantity())==1)
		    return  new ResponseEntity<String>("Iteam Succesfully added to cart",HttpStatus.CREATED);
		else
			return  new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	}
	 Products p=ps.getProductsById(cart.getProductid().getProductid());
	System.out.println(p.getQuantity());
	    if(p.getQuantity()>=c.getQuantity()+1)
	    {
		System.out.println("updating incart");
		int res = cs.updatequantity(cart.getUserid(),cart.getProductid().getProductid(),1+c.getQuantity());
		 return  new ResponseEntity<String>("Iteam Succesfully updated",HttpStatus.ACCEPTED);
	    }
	    else
	    {
	    	return  new ResponseEntity<String>("Not Enough Iteams in Stock",HttpStatus.NOT_MODIFIED);
	    }
	
		
	}
	@DeleteMapping("/{userid}/{productid}")
	public ResponseEntity<String> removeIteam(@PathVariable String userid, @PathVariable String productid)
	{System.out.println(userid);
		if( cs.removeIteam(userid, productid)==1)
			return new ResponseEntity<String>("cart iteam succesfully deleted",HttpStatus.OK);
					
			else
				return new ResponseEntity<String>("cart iteam could not  deleted",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping
	public ResponseEntity<String> updatequantity(@RequestBody Cart cart)
	{   Products p=ps.getProductsById(cart.getProductid().getProductid());
	
		if(p.getQuantity()>=cart.getQuantity())
		{
	     if(cs.updatequantity(cart.getUserid(),cart.getProductid().getProductid(),cart.getQuantity())==1)
	    return new ResponseEntity<String>("cart iteam succesfully updated",HttpStatus.ACCEPTED);
	     else
	    	 return new ResponseEntity<String>("cart iteam not succesfully updated",HttpStatus.NOT_MODIFIED);
		}
		else
		{  System.out.println("in no more stock");
			return new ResponseEntity<String>("No More iteam in stock",HttpStatus.OK);
		}
	}
}
