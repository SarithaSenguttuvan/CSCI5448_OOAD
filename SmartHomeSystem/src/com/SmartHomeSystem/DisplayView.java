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
	public static String addAdminProducts()
	{
		String details = null;
		System.out.println("Sensor Name:");
		details = input.nextLine();
		System.out.println("Sensor Type:");
		details = details + '~' + input.nextLine();
		System.out.println("Sensor Unit:");
		details = details + '~' + input.nextLine();
		System.out.println("Sensor Price:");
		details = details + '~' + input.nextLine();
		return details;
	}
	
	public static int viewUserFirstPage()
	{
		System.out.println("1.Create Network");
		System.out.println("2.View Network");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;	
	}
	
	public static int viewAdminFirstPage()
	{
		System.out.println("3.Add New Product");
		System.out.println("4.Delete Product");
		System.out.println("5.View Products");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;	
	}
}
