package com.SmartHomeSystem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Scanner;

public class ClientController
{
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();;
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public static void main(String[] args)
    {
		//Main code to start the program
		System.out.println("HelloWorld!");
		System.out.println("Welcome to the login page");
		
		String loginInput;
		String password;
		String phoneNumber;
		Scanner input = new Scanner(System.in);
		ProfileFactory profileFactory = new ProfileFactory();
		
		System.out.println("Enter the name");
		loginInput = input.nextLine();
		System.out.println("Set the Password");
		password = input.nextLine();
		System.out.println("Set the PhoneNumber");
		phoneNumber = input.nextLine();
		Person admin1 = profileFactory.createProfile("admin", loginInput, password, phoneNumber);
		admin1.printDetails();
		Person user1 = profileFactory.createProfile("user",loginInput, password, phoneNumber);
		user1.printDetails();
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			// this would save the Student_Info object into the database
			//session.save(user1);
			session.save(admin1);
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
		sessionFactory.close();
        return;        
    }
}