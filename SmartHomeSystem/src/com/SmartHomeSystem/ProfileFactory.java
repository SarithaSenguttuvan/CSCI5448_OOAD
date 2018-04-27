package com.SmartHomeSystem;

public class ProfileFactory
{
    public Person createProfile(String profileType, String _loginName, String _passWord, String _phoneNumber)
    {
        if(profileType == null)
        {
            return null;
        }
        if(profileType.equalsIgnoreCase("admin"))
        {
            return new Admin(_loginName, _passWord, _phoneNumber);
        }
        else  if(profileType.equalsIgnoreCase("user"))
        {
            return new User(_loginName, _passWord, _phoneNumber);
        }
        return null;
    }
}