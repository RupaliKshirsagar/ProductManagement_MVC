package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import com.jbk.ProductManagement_MVC.entity.User;

public interface UserDao {

	public User loginUser(User user);
	public boolean addUser(User user);
	public List<User> userList();
	
	public User getUserByUsername(String username);
}
