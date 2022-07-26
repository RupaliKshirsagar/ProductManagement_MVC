package com.jbk.ProductManagement_MVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.ProductManagement_MVC.entity.User;
import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class UserController {
	
	 @Autowired
	 private UserService service;
	
	
	@RequestMapping(value="/addUser")
	public String addUser(@ModelAttribute User user,Model model) {
		 
	boolean	isAdded = service.addUser(user);
	if(isAdded) {
		model.addAttribute("msg","User Added Successfully..!!");
		
		return "addUser";
	}
	else {
		model.addAttribute("msg","User not Added ,Check User is Already Exists..!!");
		return "addUser";
	}
		
		
		
	}
	
	@GetMapping(value="/userList")
	public String userList(Model model) {
		List<User> users=service.userList();
		for (User user : users) {
			System.out.println(user);
		}
		model.addAttribute("users", users);
		return "userList";
		
	}
	
	@RequestMapping(value = "/profile")
	public String profile(@RequestParam String username,Model model) {
		User user = service.getUserByUsername(username);
		model.addAttribute("user",user);
		
		
		return "profile";
		
	}
}
