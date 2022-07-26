package com.jbk.ProductManagement_MVC.service;

import java.util.List;

import com.jbk.ProductManagement_MVC.entity.User;

public interface UserService {

	public User loginUser(User user);
	public boolean addUser(User user);
	public List<User> userList();
	
	
	User getUserByUsername(String username);
	;
}
