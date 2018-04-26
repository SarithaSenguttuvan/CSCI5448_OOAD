import java.util.Scanner;

public class LoginPage {

	public static void main(String[] args) 
	{
		System.out.println("HelloWorld!");
		System.out.println("Welcome to the login page");
		
		String loginInput;
		String password;
		String userID;
		String phoneNumber;
		Scanner input = new Scanner(System.in);
		ProfileFactory profileFactory = new ProfileFactory();
		
		System.out.println("Enter the name");
		loginInput = input.nextLine();
		System.out.println("Set the Password");
		password = input.nextLine();
		System.out.println("Set the PhoneNumber");
		phoneNumber = input.nextLine();
		Person admin1 = profileFactory.createProfile("admin", loginInput, password, phoneNumber);
		admin1.printDetails();
		Person admin2 = profileFactory.createProfile("user",loginInput, password, phoneNumber);
		admin2.printDetails();
	}

}