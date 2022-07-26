package com.jbk.ProductManagement_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;
import com.jbk.ProductManagement_MVC.service.ProductService;
import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class ProductController {

	@Autowired
	 private ProductService service;
	
	
	@RequestMapping(value="/addProduct")
	public String addProduct(@ModelAttribute Product product,Model model) {
		 
	boolean	isAdded = service.addProduct(product);
	
	if(isAdded) {
		model.addAttribute("msg","Product Added.. Check Product is Already Exists!!");
		return "addProduct";
	}
	else {
		model.addAttribute("msg","Product not Added !!");
		return "addProduct";
	}
}
}
