package controller;
import java.util.HashMap;
import java.util.Map;


import model.User;

public class UserController implements UserControllerInterface{
//	Map	
//	In Key we will store account number, and in User we will store object
	static Map<Integer,User> map= new HashMap<Integer,User>();
	boolean isAdded=false;
	
	@Override
	public void registerUser(User user) {
		if(!map.containsKey(user.getAccountNumber())) {
			map.put(user.getAccountNumber(), user);
			isAdded=true;
		}
		else {
			System.out.println("Account Already Exist");
		}
		
		if(isAdded) {
			System.out.println("Account Created Succcessfully");
		}
		else {
			System.out.println("Account Not Created....");
		}
	}

	@Override
	public boolean loginUser(int accountNumber,String pwd) {
		if(map.containsKey(accountNumber)) {
			User user= map.get(accountNumber);
			
			if(user.getPwd().equals(pwd)) {	
				System.out.println("Login Successfull");
				return true;
				
			}
			else {
				System.out.println("Invalid Password");
				return false;
			}
		}
		else {
			System.out.println("Incorrect Account Number, Please Check Your Account Number or Create a New Account");
			return false;
		}
	}
	
	

}
