public class Group implements DisplayList
{
    private String grpName;
	private boolean grpSpecificPower;
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
        //display the setting page
    }
    public void changeGroupSettings(boolean: _grpSpecificPower)
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