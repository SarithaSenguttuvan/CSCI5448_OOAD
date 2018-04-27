package com.SmartHomeSystem;
public abstract class Product
{
    private String name;
    private int id;
    private String type;
    private String dataUnit;
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