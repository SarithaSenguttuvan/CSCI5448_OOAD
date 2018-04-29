package com.SmartHomeSystem;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name="GroupTable")
public class Group extends Subject 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "Name")
    private String grpName;
	
	@Column(name = "Power")
	private boolean grpSpecificPower;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Sensor> gsensorList = new ArrayList<Sensor>();
	
	public List<Sensor> getgsensorList()
	{
		return this.gsensorList;
	}
    
	public void setgSensorList(Sensor s)
	{
		this.gsensorList.add(s);
		System.out.println("fun:Group:setgSensorList");
		this.attach((Observer)s);
	}
	
    public void setGrpName(String _grpName)
	{
	    grpName = _grpName;
	}
	public String getGrpName()
	{
	    return grpName;   
	}
	
    public int getId()
    {
        return this.id;
    }
    public void setId(int _id)
    {
        this.id = _id;
    }
	
	public void setGrpSpecificPwr(boolean status)
	{
	    grpSpecificPower = status;
	}
	public boolean getGrpSpecificPwr()
	{
	    return grpSpecificPower;   
	}

    public void addSensorToGrp()
    {
       // gsensorList.add(_sensor);
    	int selectedSensor;
    	ClientController.getNetwork().listSensors();
		selectedSensor = DisplayView.requestSensorOption();
		DisplayView.displayInfo("Sensor selected successfully for the Group");
        Sensor sensor = null;
        Session session = ClientController.getSessionFactory().openSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            sensor = ((Sensor)session.get(Sensor.class, selectedSensor));
            this.setgSensorList(sensor);
            session.update(this);
            tx.commit();
        }
        catch(HibernateException e)
        {
            DisplayView.displayInfo("Sensor adding to group Failed exception");
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    
    public void removeSensorFromGrp(Sensor _sensor)
    {
        this.getgsensorList().remove(_sensor);
        this.detach((Observer)_sensor);
    }
    
    public void viewGroupSettings()
    {
        System.out.println("The group name is" + this.getGrpName());
        System.out.println("The group power status is" + this.getGrpSpecificPwr());
        System.out.println("The sensors in the list are ");
		this.listSensors();
    }
    public void changeGroupSettings(boolean _grpSpecificPower)
    {
        grpSpecificPower = _grpSpecificPower;
        System.out.println("fun:Group:changeGroupSettings");
        this.notifyAllObservers(_grpSpecificPower);
    }
    public void listSensors()
    {
    	int options;
    	System.out.println("************* Group Sensors *********************");
	    for (Sensor _sensor : this.getgsensorList()) 
	    {
            System.out.println(_sensor.getId()+". " +_sensor.getName()+" PowerStatus:"+_sensor.getPower());
        }
	    System.out.println("**************************************************");
	    options = DisplayView.viewGrpOptions();
	    if(options == 1)	//Add sensor to grp
	    {
	    	addSensorToGrp();
	    }
	    else if(options == 2)	//Remove sensor from grp
	    {
	    	int option;
	    	System.out.println("************* Group Sensors *********************");
		    for (Sensor _sensor : this.getgsensorList()) 
		    {
	            System.out.println(_sensor.getId()+". " +_sensor.getName()+" PowerStatus:"+_sensor.getPower());
	        }
		    System.out.println("**************************************************");
	    	option = DisplayView.requestSensorOption();
            Sensor sensor = null;
    		Session session = ClientController.getSessionFactory().openSession();
            Transaction tx = null;
            try 
            {
                tx = session.beginTransaction();
                session.refresh(this);
                Hibernate.initialize(this.getgsensorList());
                sensor = (Sensor)session.get(Sensor.class, option);
                DisplayView.displayInfo("Sensor Name:" + sensor.getName());
                this.removeSensorFromGrp(sensor);
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
	    else if(options == 3)	//Change grp settings
	    {
	    	DisplayView.displayInfo("Type the power for all sensors in group:");
	    	boolean grpPwr;
	    	grpPwr = DisplayView.getUserBoolean();
	    	this.changeGroupSettings(grpPwr);
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
	            DisplayView.displayInfo("Group Power Update failed exception");
	            if(tx!=null)
	                tx.rollback();
	            e.printStackTrace();
	        }
	        finally
	        {
	            session.close();
	        }
	    }
	    else
	    {
	    	
	    }
    }
    
    @Override
	public void attach(Observer observer)
	{
		observers.add(observer);	
		System.out.println("fun:Group:attach");
	}
	
    @Override
	public void detach(Observer observer)
	{
		observers.remove(observer);		
	}
	
    @Override
	public  void notifyAllObservers(boolean power)
    {
    	System.out.println("fun:Group:notifyAllObservers");
		for (Observer observer : observers) 
        {
        	observer.update(power);
        }
    }

}