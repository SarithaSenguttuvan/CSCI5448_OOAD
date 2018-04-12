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
		double threshold_value = System.console().readLine();
		sensor_name.location = location_name;
		sensor_name.threshold = threshold_value;
	    sensorList.add(sensor_name);
	}
	
	public boolean removeSensorFromNetwork(Sensor _sensor)
	{
	    if(sensorList.remove(_sensor) == true)
	    {
	    	//On success of removing the sensor from sensor list, remove the sensor from the group as well
	    	groupList.remove(_sensor);
	    }
	}
	
	public Group createGroup()
	{
	//     Group group = new Group();
    //     if(group != null)
    //     {
    //         groupList.add(group);
    //         return group;
    //     }
	}
	
	public boolean deleteGroup(Group _group)
	{
	    groupList.remove(_group);
	}
    
    public void listProducts()
	{
	    for (Sensor _sensor : sensorList) {
            System.out.println("_sensor = " + _sensor);
        }
	}
}