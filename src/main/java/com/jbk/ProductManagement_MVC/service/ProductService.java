package com.jbk.ProductManagement_MVC.service;

import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;

public interface ProductService {

	public User login(User user);
	public boolean addProduct(Product product);
	
}
