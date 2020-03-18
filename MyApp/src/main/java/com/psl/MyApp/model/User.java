package com.psl.MyApp.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Embeddable
@Table(name="User")
public class User {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String userid;
	String username;
	@Size(min=10,message="enter atleast 10")
	String password;
	
	
	public User() {
		
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userid, String username, @Size(min = 10, message = "enter atleast 10") String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	
}
