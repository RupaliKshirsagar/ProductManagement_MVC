package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;

public interface ProductDao {


//	public User login(User user);
	public Product addProduct(Product product);
	public List<Product> productList();
	public String uploadProducts(List<Product> productList);
	
	
}
