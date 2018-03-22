public class User extends Person
{
    public Integer numOfNetworks;
    public Network networkObj;
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