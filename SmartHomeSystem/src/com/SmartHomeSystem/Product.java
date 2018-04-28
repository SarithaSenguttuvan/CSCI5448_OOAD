package com.SmartHomeSystem;

import javax.persistence.*;

@MappedSuperclass
public abstract class Product
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "ProductName")
    private String name;
    
	@Column(name = "Type")
    private String type;
	
	@Column(name = "Unit")
    private String dataUnit;
	
	@Column(name = "Price")
    private float price;

    public String getName()
    {
        return this.name;
    }
    public void setName(String _name)
    {
        this.name = _name;
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int _id)
    {
        this.id = _id;
    }
    public String getDataUnit()
    {
        return this.dataUnit;
    }
    public void setDataUnit(String _dataUnit)
    {
        this.dataUnit = _dataUnit;
    }
    public String getType()
    {
        return this.type;
    }
    public void setType(String _type)
    {
        this.type = _type;
    }
    public float getPrice()
    {
        return this.price;
    }
    public void setPrice(float _price)
    {
        this.price = _price;
    }
    public abstract void displayHelpInfo();
}