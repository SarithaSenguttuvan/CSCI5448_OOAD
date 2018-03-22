public class Sensor extends Product
{
    private double value;
    private String location;
    private double threashold;
    private String helpInfo;
    
    public double getValue() 
    {
        return value;
    }
    public void setValue(double _value)
    {
        value = _value;
    }
    public String getLocation()
    {
        return location;
    }
    public double getThreshold()
    {
        return threashold;
    }
    public void setLocation(String _loc)
    {
        location = _loc;
    }
    public void setThreshold(double _th)
    {
        threashold = _th;
    }
    public void displayHelpInfo()
    {
        
    }
    public boolean viewSettings()
    {
        return true;
    }
    public void changeLocation(String _loc)
    {
        
    }
    public void changeThreshold(double _threshold)
    {
        
    }
    public boolean checkRange()
    {
        return true;
    }
    public void notifyUser(String _data)
    {
        
    }
}
