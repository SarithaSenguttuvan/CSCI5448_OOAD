package com.SmartHomeSystem;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Hibernate;
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
	@OneToMany(fetch = FetchType.LAZY)
    public List<Group> groupList = new ArrayList<Group>();
	
	public List<Group> getGroupList()
	{
		return this.groupList;
	}
	
	public void setGroupList(Group _grp)
	{
		this.groupList.add(_grp);
	}
	
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
            Sensor sensor = null;
    		Session session = ClientController.getSessionFactory().openSession();
            Transaction tx = null;
            try 
            {
                tx = session.beginTransaction();
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
    		this.listSensors();
    		sensorOption = DisplayView.requestSensorOption();
            Sensor sensor = null;
    		Session session = ClientController.getSessionFactory().openSession();
            Transaction tx = null;
            try 
            {
                tx = session.beginTransaction();
                session.refresh(this);
                Hibernate.initialize(this.getSensorList());
                sensor = (Sensor)session.get(Sensor.class, sensorOption);
                DisplayView.displayInfo("Sensor Name:" + sensor.getName());
                this.removeSensorFromNetwork(sensor);
                session.update(this);
                tx.commit();
            }
            catch(HibernateException e)
            {
                DisplayView.displayInfo("Sensor Removal from network failed exception");
                if(tx!=null)
                    tx.rollback();
                e.printStackTrace();
            }
            finally
            {
                session.close();
            }
    		
    	}
    	else if(option == 4) //Create group
    	{
    		this.createGroup();
    	}
    	else if(option == 5)	//View Group
    	{
    		this.listGroups();
    		sensorOption = DisplayView.requestSensorOption();
            Group group = null;
    		Session session = ClientController.getSessionFactory().openSession();
            Transaction tx = null;
            try 
            {
                tx = session.beginTransaction();
                group = (Group)session.get(Group.class, sensorOption);
                tx.commit();
            }
            catch(HibernateException e)
            {
                DisplayView.displayInfo("Viewing groups from netwoork failed exception");
                if(tx!=null)
                    tx.rollback();
                e.printStackTrace();
            }
            finally
            {
                session.close();
            }
            group.listSensors();
    	}
    	else if(option == 6)	//Remove Group
    	{
    		this.listGroups();
    		sensorOption = DisplayView.requestSensorOption();
            Group group = null;
    		Session session = ClientController.getSessionFactory().openSession();
            Transaction tx = null;
            try 
            {
                tx = session.beginTransaction();
                session.refresh(this);
                Hibernate.initialize(this.getGroupList());
                group = (Group)session.get(Group.class, sensorOption);
                this.deleteGroup(group);
                session.delete(group);
	            session.update(this);
                tx.commit();
            }
            catch(HibernateException e)
            {
                DisplayView.displayInfo("Removing groups from netwoork failed exception");
                if(tx!=null)
                    tx.rollback();
                e.printStackTrace();
            }
            finally
            {
                session.close();
            }
            
    	}
    	else if(option == 7)	//View Stats
    	{
    		Statistics statistics = new Statistics();
    		statistics.showAllSensorStats();
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
        Sensor sensor = null;
        Session session = ClientController.getSessionFactory().openSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            sensor = ((Sensor)session.get(Sensor.class, sensorId));
            sensor.sensorConfig();
            this.setSensorList(sensor);
            session.update(this);
            tx.commit();
        }
        catch(HibernateException e)
        {
            DisplayView.displayInfo("Sensor adding to nextwork exception");
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
	
	public boolean removeSensorFromNetwork(Sensor s)
	{
		this.getSensorList().remove(s);
	    return true;
	}
	
	public void createGroup()
	{
		String grpName;
		Group myGrp = new Group();			
		grpName = DisplayView.displayGetNetworkInfo(); 
		 Session session = ClientController.getSessionFactory().openSession();
	        Transaction tx = null;
	        try 
	        {
	            tx = session.beginTransaction();
	            session.refresh(this);
	            Hibernate.initialize(this.getGroupList());
	    		myGrp.setGrpName(grpName);
	            this.setGroupList(myGrp);
	            session.save(myGrp);
	            session.update(this);
	            tx.commit();
	        }
	        catch(HibernateException e)
	        {
	            DisplayView.displayInfo("Group Creation Failed exception");
	            if(tx!=null)
	                tx.rollback();
	            e.printStackTrace();
	        }
	        finally
	        {
	            session.close();
	        }
	}
	
	public boolean deleteGroup(Group grp)
	{
		this.getGroupList().remove(grp);
	    return true;
	}
    
    public void listSensors()
	{
    	System.out.println("***************** Network Sensors *********************");
	    for (Sensor sensor : this.getSensorList()) 
	    {
            System.out.println(sensor.getId() + ". " + sensor.getName());
        }
	}
    public void listGroups()
    {
    	System.out.println("***************** Groups *********************");
    	Session session = ClientController.getSessionFactory().openSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            session.refresh(this);
            Hibernate.initialize(this.getGroupList());
            for (Group grp : this.getGroupList()) 
    	    {
                System.out.println(grp.getId() + ". " + grp.getGrpName());
            }
            tx.commit();
        }
        catch(HibernateException e)
        {
            DisplayView.displayInfo("Group Creation Failed exception");
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