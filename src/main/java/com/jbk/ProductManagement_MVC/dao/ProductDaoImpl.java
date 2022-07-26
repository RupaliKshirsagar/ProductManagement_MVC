package com.jbk.ProductManagement_MVC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement_MVC.entity.Product;
import com.jbk.ProductManagement_MVC.entity.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(Product product) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean isAdded = false;
		
		try {
			Product pro = session.get(Product.class,product.getProcudtId());
			
			if(pro==null){
				session.save(product);
				tx.commit();
				isAdded = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return isAdded;
	}
	}




