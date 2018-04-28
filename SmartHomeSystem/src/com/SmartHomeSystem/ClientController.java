package com.SmartHomeSystem;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClientController
{
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();;
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	
	public static void getAdmins(ArrayList<Admin> admins)
	{
		List queryAdmins;
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			queryAdmins = session.createQuery("FROM com.SmartHomeSystem.Admin").list();
			for (Iterator iterator = queryAdmins.iterator(); iterator.hasNext();)
			{
				admins.add((Admin)iterator.next());
			}
			tx.commit();
		}
		catch(HibernateException e)
		{
			DisplayView.displayInfo("Admin retrival exception");
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public static void getUsers(ArrayList<User> users)
	{
		List queryUsers;
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			queryUsers = session.createQuery("FROM com.SmartHomeSystem.User").list();
			for (Iterator iterator = queryUsers.iterator(); iterator.hasNext();)
			{
				users.add((User)iterator.next());
			}
			tx.commit();
		}
		catch(HibernateException e)
		{
			DisplayView.displayInfo("User retrival exception");
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	//getNetwork
	public static Network getNetwork()
	{
		List queryNetworks;
		Network network = null;
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			queryNetworks = session.createQuery("FROM com.SmartHomeSystem.Network").list();
			for (Iterator iterator = queryNetworks.iterator(); iterator.hasNext();)
			{
				network = ((Network)iterator.next());
			}
			tx.commit();
		}
		catch(HibernateException e)
		{
			DisplayView.displayInfo("Network retrival exception");
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return network;
	}	
	
	public static void networkCreate()
	{
		String networkName;
		Network myNetwork = new Network();			
		networkName = DisplayView.displayGetNetworkInfo(); 
		myNetwork.setNetworkName(networkName);	
		//save to database
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			session.save(myNetwork);	// this will save the object into the database
			tx.commit();
		}
		catch(HibernateException e)
		{
			System.out.println("Saving object exception caught");
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public static void main(String[] args)
    {
		//Main code to start the program
		boolean execFlag = true;
		int loginOrSignUp;

		ArrayList<Admin> admins =  new ArrayList<Admin>();
		ArrayList<User> users =  new ArrayList<User>();
		Person person = null;
		
		//Stores all the administrator objects from the Database
		getAdmins(admins);
		getUsers(users);
		while(execFlag)
		{
			loginOrSignUp = DisplayView.displayMainPage();
			if(loginOrSignUp != 2)
			{
				String userPwd;
				String[] detailsArray;
				String loginName;
				String password;
				
				userPwd = DisplayView.loginPage();
				detailsArray = userPwd.split("~");
				
				loginName = detailsArray[0];
				password = detailsArray[1];
				
				if(loginOrSignUp == 3)
				{
					for (Iterator<Admin> iterator = admins.iterator(); iterator.hasNext();)
					{
						Admin tempAdmin = iterator.next();
						if(tempAdmin.getName().equalsIgnoreCase(loginName))
						{
							person = tempAdmin;
							break;
						}
					}
				}
				else
				{
					for (Iterator<User> iterator = users.iterator(); iterator.hasNext();)
					{
						User tempUser = iterator.next();
						if(tempUser.getName().equalsIgnoreCase(loginName))
						{
							person = tempUser;
							break;
						}
					}
				}
				if(person != null)
				{
					int optionPage; 
					while(true)
					{
						DisplayView.displayInfo(person.getName()+ " Logged In");
						optionPage = person.viewPage();
						if(optionPage == 1) //Create new network
						{
							networkCreate();
						}
						else if(optionPage == 2)	//View network
						{
							Network network = getNetwork();
							network.viewNetworkOptions();
						}
						else if(optionPage == 3)	//Admin - add new product
						{
							((Admin)person).addProducts();
						}
						else if(optionPage == 4)	//Admin - Remove Product
						{
							((Admin)person).viewProducts();
						}
						else if(optionPage == 5)	//Admin - View all products
						{
							((Admin)person).removeProducts();
						}
					}
				}
				else
				{
					DisplayView.displayInfo("No User Matches, Sign up");
					continue;
				}
			}
			else // Signup
			{
				ProfileFactory profileFactory = new ProfileFactory();
				String signUpdetails;
				String[] detailsArray;
				signUpdetails = DisplayView.displaySignUpPage();
				
				detailsArray = signUpdetails.split("~");
				
				person = profileFactory.createProfile(detailsArray[0]);
				person.setName(detailsArray[1]);
				person.setPhone(detailsArray[2]);
				person.setPassword(detailsArray[3]);
				

				Session session = getSessionFactory().openSession();
				Transaction tx = null;
				try 
				{
					tx = session.beginTransaction();
					session.save(person);	// this will save the object into the database
					tx.commit();
				}
				catch(HibernateException e)
				{
					System.out.println("Saving object exception caught");
					if(tx!=null)
						tx.rollback();
					e.printStackTrace();
				}
				finally
				{
					session.close();
				}
			}
		}      //End of while(1)
		sessionFactory.close();
    }//End of main()
}