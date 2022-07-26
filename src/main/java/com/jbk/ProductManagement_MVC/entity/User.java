package com.jbk.ProductManagement_MVC.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String username;
	private String password;
	private String gender;
	private String role;
	private String question;
	private String answer;
	private String email;
	public User(String username, String password, String gender, String role, String question, String answer,String email) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.question = question;
		this.answer = answer;
		this.email=email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", gender=" + gender + ", role=" + role
				+ ", question=" + question + ", answer=" + answer + ",email=" + email + "]";
	}
	
}
