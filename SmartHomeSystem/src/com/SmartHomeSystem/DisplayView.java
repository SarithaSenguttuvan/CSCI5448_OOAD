package com.SmartHomeSystem;

import java.util.Scanner;

public class DisplayView 
{	
	static Scanner input = new Scanner(System.in);
	public static int displayMainPage()
	{
		System.out.println("Smart Home Management System");
		System.out.println("1.UserLogin	2.Sign Up 3.Admin");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;		
	}
	
	public static String loginPage()
	{
		String user = null;
		String pwd = null;		
		
		System.out.println("UserName:");
		user = input.nextLine();
		System.out.println("Password:");
		pwd = input.nextLine();
		return (user + '~' + pwd);
	}
	
	public static void displayInfo(String s)
	{
		System.out.println(s);
	}
	
	public static String displaySignUpPage()
	{
		String details = "";
		System.out.println("Type User/Admin:");
		details = input.nextLine();
		System.out.println("Enter Login Name:");
		details = details + '~' + input.nextLine();
		System.out.println("Enter Password:");
		details = details + '~' + input.nextLine();
		System.out.println("Enter Phone Number:");
		details = details + '~' + input.nextLine();
		return details;
	}
}
