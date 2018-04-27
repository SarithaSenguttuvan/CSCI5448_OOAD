package com.SmartHomeSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class Network implements DisplayList
{
    public String networkName;
    public ArrayList<Sensor> sensorList = new ArrayList<Sensor>();
    public ArrayList<Group> groupList = new ArrayList<Group>();
    
    public void showSensorDetails()
	{
	    for (Sensor _sensor : sensorList) {
            System.out.println("_sensor = " + _sensor);
        }
	}
	
	public Sensor addSensorToNetwork(Sensor sensor_name, String _location, double _threshold)
	{
		System.out.println("Enter the location");
		String location_name = System.console().readLine();
		System.out.println("Enter the threshold");
//		double threshold_value = System.console().readLine();
		sensor_name.setLocation(location_name);
//		sensor_name.threshold = threshold_value;
	    sensorList.add(sensor_name);
	    return sensorList.get(0);
	}
	
	public boolean removeSensorFromNetwork(Sensor _sensor)
	{
	    if(sensorList.remove(_sensor) == true)
	    {
	    	//On success of removing the sensor from sensor list, remove the sensor from the group as well
	    	for (Group group_name : groupList) 
	    	{ 		      
            	if (group_name.equals(_sensor)) // check this
            	{
            		group_name.removeSensorFromGrp(_sensor);
			    	//group_name.remove(_sensor);
				} 	
		    }
	    	
	    }
	    return true;
	}
	
	public Group createGroup()
	{
	    Group group = new Group();
	    System.out.println("Enter the Group Name");
		
        if(group != null)
        {
            groupList.add(group);
        }
        return group;
	}
	
	public boolean deleteGroup(Group _group)
	{
	    groupList.remove(_group);
	    return true;
	}
    
    public void listProducts()
	{
	    for (Sensor _sensor : sensorList) {
            System.out.println("_sensor = " + _sensor);
        }
	}
}