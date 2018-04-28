package com.SmartHomeSystem;
import java.util.ArrayList;

import javax.persistence.*;

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
	
	@Column(name = "SensorList")
	public ArrayList<Sensor> gsensorList = new ArrayList<Sensor>();
    
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
        gsensorList.add(_sensor);
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
		this.listProducts();
    }
    public void changeGroupSettings(boolean _grpSpecificPower)
    {
        grpSpecificPower = _grpSpecificPower;
    }
    public void listProducts()
    {
        for (Sensor _gsensorList : gsensorList) {
            System.out.println("_gsensorList = " + _gsensorList);
        }
    }
}