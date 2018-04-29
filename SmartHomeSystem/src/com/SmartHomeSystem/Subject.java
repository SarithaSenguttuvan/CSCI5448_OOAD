package com.SmartHomeSystem;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements DisplayList
{
	protected List<Observer> observers = new ArrayList<Observer>();	

    public abstract void attach(Observer observer);
    
    public abstract void detach(Observer observer);

    public abstract void notifyAllObservers(boolean pow);
    
    public abstract void listSensors();
}