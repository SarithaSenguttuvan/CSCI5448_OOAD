package com.SmartHomeSystem;

public class ProfileFactory
{
    public Person createProfile(String profileType)
    {
        if(profileType == null)
        {
            return null;
        }
        if(profileType.equalsIgnoreCase("admin"))
        {
        	return new Admin();
        }
        else  if(profileType.equalsIgnoreCase("user"))
        {
        	return new User();
        }
        return null;
    }
}