package com.psl.MyApp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psl.MyApp.model.Cart;
import com.psl.MyApp.model.Products;
@Repository
public interface CartDAO extends CrudRepository<Cart, Long> {
	
	@Query(value="select * from Cart c where c.userid=?1", nativeQuery=true)
	public List<Cart> getCartIteams(String userid);
	
	@Modifying
	@Query(value="insert into Cart(userid,productid,quantity) value(?1,?2,?3)",nativeQuery=true)
	@Transactional
	public  int addIteam(String userid,String productid,int Quantity) ;
	
     @Modifying
	@Query(value="delete from Cart  where userid=?1 and productid=?2",nativeQuery=true)
     @Transactional
	public int removeIteam(String userid,String productid);
	
     @Modifying
     @Transactional
	@Query(value="update Cart c set c.quantity=?3 where c.userid=?1 and c.productid=?2",nativeQuery=true)
	public int updatequantity(String userid,String productid,int quantity);
	
	
	@Query(value="select * from Cart where userid=?1 and productid=?2",nativeQuery=true)
	public Cart checkCart(String userid,String productid);
}
