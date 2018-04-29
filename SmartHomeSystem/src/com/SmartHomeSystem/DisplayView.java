package com.SmartHomeSystem;

import java.util.Scanner;

public class DisplayView 
{	
	static Scanner input = new Scanner(System.in);
	public static int displayMainPage()
	{
		System.out.println("Smart Home Management System");
		System.out.println("1.UserLogin 2.Sign Up 3.Admin");
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
	public static boolean getUserBoolean()
	{
		boolean b;
		b = input.nextBoolean();
    	input.nextLine();
    	return b;
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
		System.out.println("Sensor Help:");
		details = details + '~' + input.nextLine();
		return details;
	}
	
	public static int viewUserFirstPage()
	{
		System.out.println("1.Create Network");
		System.out.println("2.View Network");
		System.out.println("6.Logout");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;	
	}
	
	public static int viewAdminFirstPage()
	{
		System.out.println("3.Add New Product");
		System.out.println("4.Delete Product");
		System.out.println("5.View Products");
		System.out.println("6.Logout");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;	
	}
	
	 
	public static String displayGetNetworkInfo()
	{
		String networkName;
		System.out.println("Enter name");
		networkName = input.nextLine();
		return networkName;
	}
	
	public static int displayNetworksFirstPage()
	{
		System.out.println("1. Add sensors");
		System.out.println("2. View sensors");
		System.out.println("3. Remove sensors");
		System.out.println("4. Create Group");
		System.out.println("5. View Group");
		System.out.println("6. Remove Group");
		System.out.println("7. View Statistics");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;			
	}
	public static String displayGetSensorInfo(String sensorName)
	{
		System.out.println("Enter sensor name");
		sensorName = input.nextLine();
		return sensorName;		
	}
	public static int displayAvailableSensorList()
	{
		//ArrayList<Sensor> sensors =  new ArrayList<Sensor>();
		ClientController.getSensors();
		displayInfo("Choose a sensor:");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line option
		return option;		
	}
	
	public static int requestSensorOption()
	{
		displayInfo("Choose Sensor:");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line
		return option;			
	}
	
	public static int requestSensorConfigOption()
	{
		displayInfo("Choose 1: Change sensor settings 2: Go Back");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line 
		return option;			
	}
	
	public static int viewGrpOptions()
	{
		displayInfo("1. Add sensor to grp");
		displayInfo("2. Remove sensor from grp");
		displayInfo("3. Change grp Settings");
		displayInfo("4. Go back");
		int option =  input.nextInt();
		input.nextLine(); //To remove the next line
		return option;	
	}
}
