package com.SmartHomeSystem;

import javax.persistence.*;

@MappedSuperclass
public abstract class Product
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "Product Name")
    private String name;
    
	@Column(name = "Type")
    private String type;
	
	@Column(name = "Unit")
    private String dataUnit;
	
	@Column(name = "Price")
    private float price;

    public String getName()
    {
        return name;
    }
    public void setName(String _name)
    {
        name = _name;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int _id)
    {
        id = _id;
    }
    public String getDataUnit()
    {
        return dataUnit;
    }
    public void setDataUnit(String _dataUnit)
    {
        dataUnit = _dataUnit;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String _type)
    {
        type = _type;
    }
    public float getPrice()
    {
        return price;
    }
    public void setPrice(float _price)
    {
        price = _price;
    }
    public abstract void displayHelpInfo();
}