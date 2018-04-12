public class User extends Person  //Should extend Server Class
{
    public Integer numOfNetworks;
    public Network networkObj;

    User(Subject subject)
    {
    	this.subject = subject;
    	this.subject.attach(this);
    }
	@Override
   	public void update() 
   	{
		System.out.println( "Added new Product" ); 
    }

    public void setNumOfNetworks(Integer _numOfNetworks)
	{
	    numOfNetworks = _numOfNetworks;
	}
	public Integer getNumOfNetworks()
	{
	    return numOfNetworks;   
	}
	public void setNetworkObj(Network _networkObj)
	{
	    networkObj = _networkObj;
	}
	public Network getNetworkObj()
	{
	    return networkObj;   
	}
    public Network createNetwork()
    {
        //signleton
        Network network = new Network();
        if(network != null)
        {
            network;
        }
    }
}