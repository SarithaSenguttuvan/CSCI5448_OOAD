public class Admin extends Person implements DisplayList
{
    Integer totalProducts;
    ArrayList<Product> productsList = new ArrayList<Product>();

    Admin()
    {
    	super(_name, _phone);
    }

    public Integer getTotalProducts()
	{
	    return totalProducts;   
	}
	public void setTotalProducts(Integer _totalProducts)
	{
	    totalProducts = _totalProducts;
	}
	public void addProducts(Product _product)
	{
	    productsList.add(_product);
	    Subject.setState();
	}
	public void removeProducts(Product _product)
	{
	    productsList.remove(_product);
	}
	public void listProducts()
	{
	    for (Product _product : productsList) {
            System.out.println("_product = " + _product);
        }
	}
}