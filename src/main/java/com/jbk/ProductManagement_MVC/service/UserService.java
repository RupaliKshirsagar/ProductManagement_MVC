package com.jbk.ProductManagement_MVC.service;

import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.ProductManagement_MVC.entity.ForgotPassword;
import com.jbk.ProductManagement_MVC.entity.User;

public interface UserService {

	public User loginUser(User user);
	public boolean  addUser(User user);
	public List<User> userList();
	
	public User getUserByUsername(String username);
	public boolean updateUser(User user);
	public boolean deleteUser(String username);
	
	public String uploadSheet(CommonsMultipartFile file,HttpSession httpSession);
	
	public String forgotPassword(ForgotPassword forgotpassword);
	public boolean logout(HttpSession httpSession);
}
