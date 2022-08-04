package com.jbk.ProductManagement_MVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value = "/")
	public String loginPage() {
		return "login";
		
	}
	

	@RequestMapping(value = "/addUserPage")
	public String addUserPage() {
		return "addUser";
		
	}
	
	@RequestMapping(value = "/addProductPage")
	public String addProductPage() {
		return "addProduct";
		
	}
	@RequestMapping(value = "/homePage")
	public String homePage() {
		return "home";
		
	}
	
	@RequestMapping(value = "/importUsersPage")
	public String importUsersPage() {
		return "importUsers";
		
	}
	@RequestMapping(value = "/importProductsPage")
	public String importProductsPage() {
		return "importProducts";
		
	}
	
	@RequestMapping(value = "/forgotPasswordPage")
	public String forgotPasswordPage() {
		return "forgotPassword";
		
	}
	
	
	
//	@RequestMapping(value = "addUser")
//	public String addUser() {
//		return "addUser";
//		
//	}
//	
//	@RequestMapping(value = "addProduct")
//	public String addProduct() {
//		return "addProduct";
//		
//	}
//	
//	@RequestMapping(value = "userProfile")
//	public String userProfile() {
//		return "profile";
//		
//	}
	

}
