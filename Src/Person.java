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
 *****
 *
 */

public class Person
{
	private String name;
	private String phone;
	private String password;
	public void setName(String _name)
	{
	    name = _name;
	}
	public String getName()
	{
	    return name;   
	}
	public void setPhone(String _phone)
	{
	    phone = _phone;
	}
	public String getPhone()
	{
	    return phone;   
	}
	public void setPassword(String _password)
	{
	    password = _password;
	}
	public String getPassword()
	{
	    return password;
	}
}