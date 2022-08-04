package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.ProductManagement_MVC.entity.ForgotPassword;
import com.jbk.ProductManagement_MVC.entity.User;

public interface UserDao {

	public User loginUser(User user);
	public boolean addUser(User user);
	public List<User> userList();
	
	public User getUserByUsername(String username);
	public boolean updateUser(User user);
	public boolean deleteUser(String username);
	public String uploadUsers(List<User> userList);
	
	public String forgotPassword(ForgotPassword forgotpassword);
	public boolean logout(HttpSession httpSession);
	
	
	
}
