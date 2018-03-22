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
	
	public Sensor addSensorToNetwork()
	{
	    //sensorList.add(_sensor);
	}
	
	public boolean removeSensorFromNetwork(Sensor _sensor)
	{
	    //sensorList.remove(_sensor);
	    //on success
	    //groupList.remove(_sensor);
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