package com.SmartHomeSystem;
import javax.persistence.*;

/**
 * @file 
 *		Person.java 
 * @brief 
 *		This file contains the class related to the Person class which has characteristics common to both Admin and User
 *		 
 * @author 
 *		
 * @date 
 *		March 21, 2018
 **********
 *
 */
@MappedSuperclass
public abstract class Person
{	
	@Id
	@GeneratedValue
	private int Id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Password")
	private String password;
	
	public int getId()
	{
		return this.Id;
	}
	
	public void setId(int _id)
	{
		this.Id = _id;
	}
	
	public void setName(String _name)
	{
	    this.name = _name;
	}
	
	public String getName()
	{
	    return this.name;   
	}
	
	public void setPhone(String _phone)
	{
	    this.phone = _phone;
	}
	
	public String getPhone()
	{
	    return this.phone;   
	}
	
	public void setPassword(String _password)
	{
	    this.password = _password;
	}
	
	public String getPassword()
	{
	    return password;
	}
	public abstract int viewPage();
	
}