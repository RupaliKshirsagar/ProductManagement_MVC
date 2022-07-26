package com.jbk.ProductManagement_MVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.ProductManagement_MVC.dao.ProductDao;
import com.jbk.ProductManagement_MVC.dao.UserDao;
import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(Product product) {
		
		 return dao.addProduct(product);
	}

	
	

}
