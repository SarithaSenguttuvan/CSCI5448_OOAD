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
public class Person
{	
	@Id
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Password")
	private String password;
	
	Person(String _name, String _password, String _phone)
	{
		System.out.println("Person constructor called");
		setName(_name);
		setPassword(_password);
		setPhone(_phone);
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
	public void printDetails()
	{
		System.out.println("UserName");
		System.out.println(this.name);
		System.out.println("Phone Number");
		System.out.println(this.phone);
		System.out.println("Password");
		System.out.println(this.password);
	}
}