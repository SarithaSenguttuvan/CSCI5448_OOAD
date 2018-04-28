package com.SmartHomeSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name="Networktable")
public class Network implements DisplayList
{
	@Id
	@GeneratedValue
	public int Id;
	
	@Column(name = "NetworkName")
    public String networkName;
    
	//@Column(name = "Sensor List")
	@OneToMany(fetch = FetchType.EAGER)
    private List<Sensor> sensorList = new ArrayList<Sensor>();
	
	//@Column(name = "Group List")
   // public ArrayList<Group> groupList = new ArrayList<Group>();
    public List<Sensor> getSensorList()
    {
    	return this.sensorList;
    }
    
    public void setSensorList(Sensor s)
    {
    	this.sensorList.add(s);
    }
    
    public String getNetworkName()
    {
    	return this.networkName;
    }
    public void setNetworkName(String _myNetworkName)
    {
    	this.networkName = _myNetworkName;
    }
    
	
    public void viewNetworkOptions()
    {
    	int option;
    	option = DisplayView.displayNetworksFirstPage();
    	int sensorOption;
    	int sensorConfigOption;
    	if(option == 1) //Add sensors
    	{
    		this.addSensorToNetwork();
    	}
    	else if(option == 2)// View Sensors that are added to the network
    	{
    		this.listSensors();
    		sensorOption = DisplayView.requestSensorOption();
    		List querySensors;
            Sensor sensor = null;
    		Session session = ClientController.getSessionFactory().openSession();
            Transaction tx = null;
            try 
            {
                tx = session.beginTransaction();
//                querySensors = session.createQuery("FROM com.SmartHomeSystem.Sensor E WHERE E.id = :sensorOption").list();
//                for (Iterator iterator = querySensors.iterator(); iterator.hasNext();)
//                {
//                    sensor = ((Sensor)iterator.next());
//                }
                sensor = (Sensor)session.get(Sensor.class, sensorOption);
                tx.commit();
            }
            catch(HibernateException e)
            {
                DisplayView.displayInfo("Sensor retrival exception");
                if(tx!=null)
                    tx.rollback();
                e.printStackTrace();
            }
            finally
            {
                session.close();
            }
            sensor.showSensorDetails();
            sensorConfigOption = DisplayView.requestSensorConfigOption();
            if(sensorConfigOption == 1)
            {
            	sensor.sensorConfig();
            }
            else
            {
            	
            }
    		
    	}
    	else if(option == 3) //Remove Sensors
    	{
    		this.removeSensorFromNetwork();
    	}
    	else if(option == 4) //Create group
    	{
    		this.createGroup();
    	}
    	else if(option == 5)	//View Group
    	{
    		
    	}
    	else if(option == 6)	//Remove Group
    	{
    		this.deleteGroup();
    	}
    }
    
	public void addSensorToNetwork()
	{
		int selectedSensor;
		selectedSensor = DisplayView.displayAvailableSensorList();
		DisplayView.displayInfo("Sensor selected successfully");
		addSensorToList(selectedSensor);
	}

	public void addSensorToList(int sensorId)
    {
        List querySensors;
        Sensor sensor = null;
        Session session = ClientController.getSessionFactory().openSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            querySensors = session.createQuery("FROM com.SmartHomeSystem.Sensor").list();
            for (Iterator iterator = querySensors.iterator(); iterator.hasNext();)
            {
            	
                sensor = ((Sensor)iterator.next());
                System.out.println(sensor.getId());
                if(sensorId == sensor.getId())
                {
                	DisplayView.displayInfo("Sensor added successfully");
                	break;
                }
            }
            sensor.sensorConfig();
            this.setSensorList(sensor);
            session.update(this);
            tx.commit();
        }
        catch(HibernateException e)
        {
            DisplayView.displayInfo("Sensor retrival exception");
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
	
	public boolean removeSensorFromNetwork()
	{
	    //Update the database
	    return true;
	}
	
	public void createGroup()
	{
//		String grpName;
//		Group myGrp = new Group();			
//		grpName = DisplayView.displayGetNetworkInfo(); 
//		myGrp.setNetworkName(grpName);
	}
	
	public boolean deleteGroup()
	{
	    return true;
	}
    
    public void listSensors()
	{
    	System.out.println("LIst Sensors *********************");
	    for (Sensor sensor : this.getSensorList()) 
	    {
            System.out.println(sensor.getId() + ". " + sensor.getName());
        }
	}
}