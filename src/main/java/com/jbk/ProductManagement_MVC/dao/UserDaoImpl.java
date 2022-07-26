package com.jbk.ProductManagement_MVC.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement_MVC.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public User loginUser(User user) {
		Session session = sf.openSession();
		User usr=null;
		try {
			usr = session.get(User.class, user.getUsername());
			if(usr!=null) {
			if(!usr.getPassword().equals(user.getPassword())) {
				 usr = null;
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return usr;
	}


	@Override
	public boolean addUser(User user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean isAdded = false;
		
		try {
			User usr = session.get(User.class,user.getUsername());
			
			if(usr==null){
				session.save(user);
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


	@Override
	public List<User> userList() {
		Session session = sf.openSession();
		List<User> list=null;
		try {
//			Criteria criteria=session.createCriteria(User.class);
//			List<User> userList =  criteria.list();
			list=session.createCriteria(User.class).list();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		return list;
	}


	
		


	@Override
	public User getUserByUsername(String username) {
		Session session = sf.openSession();
		User user=null;
		try {
			user=session.get(User.class, username);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}



		
	

}
