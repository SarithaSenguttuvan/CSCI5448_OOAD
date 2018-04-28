package com.SmartHomeSystem;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name="AdminTable")
public class Admin extends Person //implements DisplayList
{
	@Column(name = "TotalProduts")
	private int totalProducts;
	
	public int getTotalProducts()
	{
		return this.totalProducts;
	}
	
	public void setTotalProducts(int _total)
	{
		this.totalProducts = _total;
	}
	
	public int viewPage()
	{
		return DisplayView.viewAdminFirstPage();
	}
	
	public void viewProducts()
	{
		
	}
	
	public void removeProducts()
	{
		
	}
	
	public void addProducts()
	{
		String[] details;
		details = DisplayView.addAdminProducts().split("~");
		Product product = new Sensor();
		product.setName(details[0]);
		product.setType(details[1]);
		product.setDataUnit(details[2]);
		product.setPrice(Float.parseFloat(details[3]));
		
		Session session = ClientController.getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			session.save(product);	// this will save the object into the database
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
}