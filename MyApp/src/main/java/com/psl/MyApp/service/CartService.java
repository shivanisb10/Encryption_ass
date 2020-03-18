package com.psl.MyApp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.MyApp.DAO.CartDAO;
import com.psl.MyApp.model.Cart;
import com.psl.MyApp.model.Products;

@Service

public class CartService {

	@Autowired
	CartDAO cd;
	
	public float calculatePrice(String userid)
	{ 
		float result=0;
		List<Cart> c=(List<Cart>)cd.getCartIteams(userid);
		Iterator<Cart> itr=c.iterator();
		while(itr.hasNext())
		{
			Cart k=itr.next();
			result=result+k.getProductid().getPrice()*k.getQuantity();
			
		}
		return result;
	}
	
	public List<Cart> getCartIteams(String userid)
	{
		return (List<Cart>)cd.getCartIteams(userid);
		
	}
	public Cart checkCart(String userid,String productid)
	{
		return (Cart )cd.checkCart(userid,productid);
		
	}
	
	public int addIteam(String userid,String productid,int Quantity)
	{
		return cd.addIteam(userid, productid, Quantity);
	}
     
	
	public int removeIteam(String userid,String productid)
	{
		return cd.removeIteam(userid, productid);
	}
	
	public int updatequantity(String userid,String productid,int quantity)
	{
		return cd.updatequantity(userid, productid, quantity);
	}
}
