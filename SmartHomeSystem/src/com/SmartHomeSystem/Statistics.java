package com.SmartHomeSystem;

import java.util.Iterator;
import java.util.List;

public class Statistics 
{
	public void showAllSensorStats()
	{
		List<Sensor> sensors = ClientController.getNetwork().getSensorList();
		DisplayView.displayInfo("*************STATISTICS******************");
		DisplayView.displayInfo("Sensor Name			Location				Value");
		DisplayView.displayInfo("*****************************************");
		for (Iterator<Sensor> iterator = sensors.iterator(); iterator.hasNext();)
		{
			Sensor s;
			s = ((Sensor)iterator.next());
			System.out.println(s.getName()+"			"+ s.getName()+"				"+s.getValue());
		}
	}
}
