package com.jbk.ProductManagement_MVC.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;

public interface ProductService {

	//public User login(User user);
	public Product addProduct(Product product);
	
	public List<Product> productList();
	public String uploadSheet(CommonsMultipartFile file,HttpSession httpSession);
}
