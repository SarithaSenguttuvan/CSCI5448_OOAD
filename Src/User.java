import java.util.Scanner;

public class User extends Person //implements DisplayList
{
    User(String _name, String _password, String phoneNumber)
    {
    	super(_name, _password, phoneNumber);
    	System.out.println("Admin constructor called");
    }
}