public class ClientController
{
    public static void main(String[] args)
    {
		System.out.println("Hello! Welcome to the Smart Home page");
		System.out.println("1. Admin login");
		System.out.println("2. Customer login");
		int userEntry = System.console().readLine();
		Subject subject = new Subject();

		new User(subject);
		subject.setState();

        return;        
    }
}