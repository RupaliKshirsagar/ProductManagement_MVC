package com.jbk.ProductManagement_MVC.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbk.ProductManagement_MVC.entity.ForgotPassword;
import com.jbk.ProductManagement_MVC.entity.User;
import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/login")
	public String login(@ModelAttribute User user ,Model model,HttpSession session) { // ModelAttribute-->Frontend to Backend data flow
		
		//System.out.println(user); // error not return
	User usr = service.loginUser(user);
	
	if(usr!=null) {
		session.setAttribute("userRole", usr.getRole());
		session.setAttribute("username", usr.getUsername());
		
		return "home";
	}
	else {
		// data Flow Backend to FrontEnd Use Model
		model.addAttribute("msg","Invalid Credintials !!!!");
		return "login";
	}
		
	//	return "home";
		
	}
	
	@PostMapping(value="forgotPasswordOfUser")
	public String forgotPasswordOfUser(@ModelAttribute ForgotPassword forgotPassword,Model model) {

		String message=service.forgotPassword(forgotPassword);
	
		model.addAttribute("msg", message);
		return "forgotPassword";
		
	}
	
}
