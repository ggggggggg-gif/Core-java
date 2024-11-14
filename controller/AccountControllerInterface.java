package controller;

public interface AccountControllerInterface {
	double deposit(int accountNumber,double amount);
	double withdraw(int accountNumber,double amount);
	double checkBal(int accountNumber);
	long changePhoneNumber(int accountNumber,long phoneNumber);
	String changeEmail(int accountNumber,String email);
	String updateName(int accountNumber,String name);
	boolean changePassword(int accountNumber,String oldPwd,String newPwd);

}
