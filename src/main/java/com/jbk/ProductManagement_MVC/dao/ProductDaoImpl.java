package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.servlet.http.HttpSession;

import com.jbk.ProductManagement_MVC.entity.Product;
//import com.jbk.ProductManagement_MVC.entity.User;
//import com.jbk.ProductManagement_MVC.entity.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sf;
	
	
//	@Override
//	public User login(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Product addProduct(Product product) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Product pro=null;
		
		try {
				session.save(product);
				tx.commit();
				pro=product;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return pro;
	}

	
		@SuppressWarnings("deprecation")
		@Override
		public List<Product> productList() {
			Session session = sf.openSession();
			List<Product> list=null;
			try {
//				Criteria criteria=session.createCriteria(User.class);
//				List<User> userList =  criteria.list();
				list=session.createCriteria(Product.class).list();
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				session.close();
			}
			return list;  
		}
//		@Override
//		public List<Product> productList() {
//			Session session = sf.openSession();
//			List<Product> prodList = session.createCriteria(Product.class).list();
//			session.close();
//			return prodList;
//		}

		


		@Override
		public String uploadProducts(List<Product> productList) {
			
			Session session = null;
			Transaction transaction = null;
			String message = null;
			int count = 0;

			try {
				if (productList != null) {
					for (Product product : productList) {
						session = sf.openSession();
						transaction = session.beginTransaction();

						session.save(product);
						transaction.commit();
						count = count + 1;

					}
					message = count + " Product uploaded";
				}else {
					message="first select file";
				}

				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}

			return message;
		}

	}

		

	




