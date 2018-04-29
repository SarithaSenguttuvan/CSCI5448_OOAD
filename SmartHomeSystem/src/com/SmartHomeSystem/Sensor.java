package com.SmartHomeSystem;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

@Entity
@Table(name = "SensorTable")
public class Sensor extends Product
{
	@Column(name = "Reading")
    private double value;
	
	@Column(name = "Location")
    private String location;
	
	@Column(name = "Threshold")
    private double threashold;
	
	@Column(name = "Power")
    private boolean power;
    
    public boolean getPower()
    {
        return power;
    }
    public void setPower(boolean _power)
    {
        power = _power;
    }
    public double getValue() 
    {
        return value;
    }
    public void setValue(double _value)
    {
        value = _value;
    }
    public String getLocation()
    {
        return location;
    }
    public double getThreshold()
    {
        return threashold;
    }
    public void setLocation(String _loc)
    {
        location = _loc;
    }
    public void setThreshold(double _th)
    {
        threashold = _th;
    }
    public void displayHelpInfo()
    {
        System.out.println(this.getHelpInfo());
    }
    public boolean viewSettings()
    {
        System.out.println("Location: "+ getLocation());
        System.out.println("Threshold: "+ getThreshold());
        System.out.println("Value: "+ getValue());
        System.out.println("Power Status: "+ getPower());
        return true;
    }
    public void changeLocation(String _loc)
    {
        setLocation(_loc);
    }
    public void changeThreshold(double _threshold)
    {
        setThreshold(_threshold);
    }
    public boolean checkRange()
    {
        if(getValue() > getThreshold())
        {
            notifyUser("Sensor went over the threshold value" + getValue());
        }
        else
        {
            notifyUser("Sensor is inside the threshold limit");
        }
        return true;
    }
    public void notifyUser(String _data)
    {
        System.out.println(_data);
    }
    
    public void showSensorDetails()
    {
    	System.out.println(this.getName()+ " details");
    	System.out.println("Location: "+ this.getLocation());
    	System.out.println("Power: "+ this.getPower());
    	System.out.println("Threshold: "+ this.getThreshold());
    	System.out.println("Reading: "+ this.getValue());
    }
    
    public void sensorConfig()
    {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the location");
    	this.setLocation(input.nextLine());
 
    	System.out.println("Enter Power status");
    	this.setPower(input.nextBoolean());
    	input.nextLine();

    	System.out.println("Enter the threshold");
    	this.setThreshold(input.nextDouble());
    	input.nextLine();
    	
    	System.out.println("Enter the Value");
    	this.setValue(input.nextDouble());
    	input.nextLine();
    	
    	Session session = ClientController.getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			session.update(this);
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
    }
    
}
