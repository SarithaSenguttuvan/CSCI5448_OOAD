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

public class Person
{
	String name;
	PhoneNumber phone;
	String *password;
	Person(String _name, String _phone)
	{
		setName(_name);
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
	public PhoneNumber getPhone()
	{
	    return this.phone;   
	}
	public void setPassword(String *_password)
	{
	    this.password = _password;
	}
	public String getPassword()
	{
	    return password;
	}
}