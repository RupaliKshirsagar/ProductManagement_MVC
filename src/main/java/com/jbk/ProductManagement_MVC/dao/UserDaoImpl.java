package com.jbk.ProductManagement_MVC.dao;


import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement_MVC.entity.ForgotPassword;
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

	@SuppressWarnings("deprecation")
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


	@Override
	public boolean updateUser(User user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean isUpdated = false;
		
		try {
				session.update(user);
				tx.commit();
				isUpdated = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return isUpdated;
	
	}


	@Override
	public boolean deleteUser(String username) {
		Session session = sf.openSession();
		Transaction transaction=session.beginTransaction();
		boolean b=false;
		List<User> userList=null;		
		try {
			User user = session.get(User.class, username);
			if(user!=null) {
					session.delete(user);
			transaction.commit();
			b=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return b;
	}


	@Override
	public String uploadUsers(List<User> userList) {
		Session session=null;
		Transaction transaction=null;
		int count = 0;
		int excluded = 0;
		try {
			for (User user : userList) {
				 session=sf.openSession();
				 transaction=session.beginTransaction();
				
				User usr=session.get(User.class,user.getUsername());
				if(usr!=null) {
					if(!usr.getUsername().equals(user.getUsername())) {
						session.save(user);
						
						transaction.commit();
						count=count+1;
					}else {
						excluded=excluded+1;
					}
				}else {
					session.save(user);
					transaction.commit();
					count=count+1;
				}
				
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count+"  User Inerted,"+" "+excluded +"  Excludes (Already Exist)!!";
	}


	@Override
	public String forgotPassword(ForgotPassword forgotPassword) {
		Session session = sf.openSession();
		Transaction tt = session.beginTransaction();
		String msg = null;

		String username = forgotPassword.getUsername();
		User user = session.get(User.class, username);
	
		try {
			if (user != null) {

				if (forgotPassword.getQuestion().equals(user.getQuestion())
						&& forgotPassword.getAnswer().equals(user.getAnswer())) {

					if (forgotPassword.getNewpassword().equals(forgotPassword.getConfirmpassword())) {
						user.setPassword(forgotPassword.getNewpassword());
						String password=user.getPassword();
					    String encryptedpassword = null;  
					    Encoder encoder = Base64.getEncoder();
				        encryptedpassword = encoder.encodeToString(password.getBytes());
				        user.setPassword(encryptedpassword);
						session.update(user);
						tt.commit();
						msg = "Password reset Successfully";

					} else {

						msg = "New password and confirm password should be same";
					}

				} else {
					msg = "Please select correct security question and answer";
				}
			} else {
				msg = "User not existed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}



	@Override
	public boolean logout(HttpSession httpSession) {
	
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		boolean isLogout=false;
		try {
			String isActive=(String)httpSession.getAttribute("status");
			String username=(String)httpSession.getAttribute("name");
			isActive="0";
			User user = (User)session.get(User.class, username);
			user.setIsActive(isActive);
			session.update(user);
			isLogout=true;
			transaction.commit();
			return isLogout;
		}catch(Exception e) {
			
		}finally {
			session.clear();
		}
		return false;
	}
}



		
	

