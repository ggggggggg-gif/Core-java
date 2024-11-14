package controller;

import model.User;

public class AccountController implements AccountControllerInterface {
	
	@Override
	public double deposit(int accountNumber, double amount) {
		User user= UserController.map.get(accountNumber);
		double newBal= user.getBalance()+ amount;
		user.setBalance(newBal);
		return user.getBalance();
	}

	@Override
	public double withdraw(int accountNumber, double amount) {
		User user= UserController.map.get(accountNumber);
		double bal= user.getBalance();
		double newBal= bal-amount;
		user.setBalance(newBal);
		return newBal;	
	}

	@Override
	public double checkBal(int accountNumber) {
		User user= UserController.map.get(accountNumber);
		return user.getBalance();
	}

	@Override
	public long changePhoneNumber(int accountNumber, long phoneNumber) {
		User user= UserController.map.get(accountNumber);
		user.setPhone(phoneNumber);
		return user.getPhone();
	}

	@Override
	public String changeEmail(int accountNumber, String email) {
		User user= UserController.map.get(accountNumber);
		user.setEmail(email);
		return user.getEmail();
	}

	@Override
	public String updateName(int accountNumber, String name) {
		User user= UserController.map.get(accountNumber);
		user.setName(name);
		return user.getName();
	}

	@Override
	public boolean changePassword(int accountNumber, String oldPwd,String newPwd) {
		User user= UserController.map.get(accountNumber);
		if(user.getPwd().equals(oldPwd)) {
			user.setPwd(newPwd);
			return true;	
		}
		else {
			return false;
		}
	}

}
