package com.SmartHomeSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name="GroupTable")
public class Group implements DisplayList
{
	@Id
	@GeneratedValue
	private int Id;
	
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
	}
	
    public void setGrpName(String _grpName)
	{
	    grpName = _grpName;
	}
	public String getGrpName()
	{
	    return grpName;   
	}
	
	public void setGrpSpecificPwr(boolean status)
	{
	    grpSpecificPower = status;
	}
	public boolean getGrpSpecificPwr()
	{
	    return grpSpecificPower;   
	}

    public void addSensorToGrp(Sensor _sensor)
    {
       // gsensorList.add(_sensor);
    	int selectedSensor;
    	ClientController.getNetwork().listSensors();
		selectedSensor = DisplayView.requestSensorOption();
		DisplayView.displayInfo("Sensor selected successfully for the Group");
    	List querySensors;
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
    
    public void removeSensorFromGrp(Sensor _sensor)
    {
        gsensorList.remove(_sensor);
    }
    
    public void viewGroupSettings()
    {
        System.out.println("The group name is" + this.getGrpName());
        System.out.println("The group power status is" + this.getGrpSpecificPwr());
        System.out.println("The sensors in the list are ");
		String _grpName = System.console().readLine();
		this.listSensors();
    }
    public void changeGroupSettings(boolean _grpSpecificPower)
    {
        grpSpecificPower = _grpSpecificPower;
    }
    public void listSensors()
    {
    	System.out.println("************* Group Sensors *********************");
	    for (Sensor _sensor : this.getgsensorList()) 
	    {
            System.out.println(_sensor.getId()+". " +_sensor.getName());
        }
    }
}