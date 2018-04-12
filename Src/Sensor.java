public class Sensor extends Product
{
    private double value;
    private String location;
    private double threashold;
    private String helpInfo;
    private boolean power;
    
    public boolean getPower()
    {
        return power;
    }
    public void setPower(boolean _power)
    {
        power = _power;
    }
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
        System.out.println(helpInfo);
    }
    public boolean viewSettings()
    {
        System.out.println("Location: "+ getLocation());
        System.out.println("Threshold: "+ getThreshold());
        System.out.println("Value: "+ getValue());
        System.out.println("Power Status: "+ getPower());
        return true;
    }
    public void changeLocation(String _loc)
    {
        setLocation(_loc);
    }
    public void changeThreshold(double _threshold)
    {
        setThreshold(_th);
    }
    public boolean checkRange()
    {
        if(getValue() > getThreshold())
        {
            notifyUser("Sensor went over the threshold value" + getValue()
        }
        else
        {
            
        }
        return true;
    }
    public void notifyUser(String _data)
    {
        System.out.println(_data);
    }
    
}
