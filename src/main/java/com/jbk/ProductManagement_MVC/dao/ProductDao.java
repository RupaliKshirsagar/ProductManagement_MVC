package com.jbk.ProductManagement_MVC.dao;

import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;

public interface ProductDao {


	public User login(User user);
	public boolean addProduct(Product product);
	
}
