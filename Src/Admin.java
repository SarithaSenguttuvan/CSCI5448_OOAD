import java.util.Scanner;

public class Admin extends Person //implements DisplayList
{
    Admin(String _name, String _password, String phoneNumber)
    {
    	super(_name, _password, phoneNumber);
    	System.out.println("Admin constructor called");
    }

}