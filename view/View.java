package view;


import java.util.Scanner;
//import java.util.random.*;

import controller.UserController;
import controller.UserControllerInterface;
import model.User;
import controller.AccountController;
import controller.AccountControllerInterface;

public class View {
	static UserControllerInterface controller= new UserController();
	Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		View view=new View();
		view.StartingMenu();
			}
	
	
//	Display To User 
	public void StartingMenu() {
	while(true) {
	System.out.println("Welcome To Bank");
	System.out.println("Press 1 to Register Your Account");
	System.out.println("Press 2 to Login Your Account");
	System.out.println("Press 3 to Logout");
	System.out.println("Press 4 to Exit");
	System.out.println("Select Your Choice: ");
	
	int choice= sc.nextInt();
	
	switch(choice) {
	case 1: 
		registration();
		break;
	
	case 2:
		login();
		break;
	
	case 3:
		System.out.println("Logged Out Successfully");
		break;
		
	case 4: 
		System.out.println("Thank You, Visit Again");
		System.exit(0);
	
	default:
		System.out.println("Invalid Choice");
		break;
	}
	}
}
	
	
//	To Create New Account
	public void registration() {
		System.out.println("Enter Your Account Number");
		int accountNumber= sc.nextInt();
		System.out.println("Enter Your Name");
		sc.nextLine();
		String name= sc.nextLine();
		System.out.println("Enter your Password");
		String pwd= sc.next();
		System.out.println("Enter your email");
		String email= sc.next();
		System.out.println("Enter Your Phone Number");
		long phone= sc.nextLong();
		System.out.println("Enter the balance you want to deposit");
		double balance= sc.nextDouble();
		controller.registerUser(new User(name,pwd,email,phone,accountNumber,balance));
	}
	
//	To Login
	public void login() {
		System.out.println("Enter Your Account Number");
		int accountNumber=sc.nextInt();
		System.out.println("Enter your password");
		String pwd= sc.next();
		boolean result= controller.loginUser(accountNumber, pwd);
		if(result) {
			userMenu(accountNumber);
		}
		else {
			return;
		}
		
	}
	
	public void userMenu(int accountNumber) {
		while(true) {
			System.out.println("Welcome");
			System.out.println("Press 1 to Deposit");
			System.out.println("Press 2 to Withdraw");
			System.out.println("Press 3 to Check Balance");
			System.out.println("Press 4 to Change Phone Number");
			System.out.println("Press 5 to Change Email");
//			System.out.println("Press 6 to Update Your Name");
			System.out.println("Press 6 to Change Your Password");
			System.out.println("Select Your Choice: ");
			
			int choice= sc.nextInt();
			AccountControllerInterface accountController= new AccountController();
			switch (choice) {
			case 1: {
				System.out.println("Enter the amount you want to deposit");
				double amount= sc.nextDouble();
				double newBal= accountController.deposit(accountNumber, amount);
				System.out.println("Deposit Successfull");
				System.out.println("Your new Balance is: "+ newBal);
				break;
				
			}
			case 2:{
				System.out.println("Enter the amount you want to withdraw...");
				double amount= sc.nextDouble();		
				double newBal= accountController.withdraw(accountNumber, amount);
				System.out.println("Withdraw Successfull");
				System.out.println("Your new Balance is: "+ newBal);
				break;
			}
			case 3:{
				System.out.println("Your Balance is: " + accountController.checkBal(accountNumber));
				break;
			}
			case 4:{
				System.out.println("Enter your new Phone Number");
				long phoneNumber= sc.nextLong();
				System.out.println("Your new Phone Number is: "+ accountController.changePhoneNumber(accountNumber, phoneNumber));
				break;
			}
			case 5:{
				System.out.println("Enter your new Email");
				String email= sc.next();
				System.out.println("Your new Email is: "+ accountController.changeEmail(accountNumber, email));
				break;
			}
			case 6:{
				System.out.println("Enter Your Old Password");
				String oldPassword= sc.next();
				System.out.println("Enter Your New Password");
				String newPassword= sc.next();
				boolean result= accountController.changePassword(accountNumber, oldPassword, newPassword);
				if(result) {
					System.out.println("Password Changed Successfully");
					break;
				}
				else {
					System.out.println("Old Password is Incorrect, Please Try Again...");
					break;
					
				}
			}
			default:
				System.out.println("Please Select a Correct Option");
				break;
			}
		}
	}

}
