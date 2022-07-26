package com.jbk.ProductManagement_MVC.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.ProductManagement_MVC.dao.UserDao;
import com.jbk.ProductManagement_MVC.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User loginUser(User user) {
		
		
		return dao.loginUser(user);
	}

	@Override
	public boolean addUser(User user) {
		
		return dao.addUser(user);
	}

	@Override
	public List<User> userList() {
		
		return dao.userList();
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUsername(username);
	}
	
	
	}


