package controller;

import model.User;

public interface UserControllerInterface {
	void registerUser(User user);
	
	boolean loginUser(int accountNumber,String pwd);
}
