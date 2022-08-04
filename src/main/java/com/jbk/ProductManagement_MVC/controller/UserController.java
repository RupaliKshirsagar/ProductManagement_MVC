package com.jbk.ProductManagement_MVC.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.ProductManagement_MVC.entity.User;
import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/addUser")
	public String addUser(@ModelAttribute User user, Model model) {

		boolean isAdded = service.addUser(user);
		if (isAdded) {
			model.addAttribute("msg", "User Added Successfully..!!");

			return "addUser";
		} else {
			model.addAttribute("msg", "User not Added ,Check User is Already Exists..!!");
			return "addUser";
		}

	}

	@GetMapping(value = "/userList")
	public String userList(Model model) {
		List<User> users = service.userList();
		for (User user : users) {
			System.out.println(user);
		}
		model.addAttribute("users", users);
		return "userList";

	}

	@RequestMapping(value = "/getProfile")
	public String profile(@RequestParam String username, Model model) {
		User user = service.getUserByUsername(username);
		model.addAttribute("user", user);

		return "profile";

	}

	@PostMapping(value = "/updateUser")
	public String updateUser(@ModelAttribute User user, Model model) {
		boolean isUpdated = service.updateUser(user);
		if (isUpdated) {
			model.addAttribute("msg", "Successfully Updated !!");
			return "profile";
		} else {
			model.addAttribute("msg", "Not Updated !!");
			return "profile";
		}

	}

	@GetMapping(value = "/deleteUser")
	public String deleteUser(@RequestParam String username, Model model) {
		boolean isDeleted = service.deleteUser(username);
		List<User> userList = service.userList();
		if (isDeleted) {
			model.addAttribute("msg", "Deleted");

			return "userList";
		} else {
			model.addAttribute("users", userList);
			model.addAttribute("msg", "Not Deleted");
			return "userList";
		}

	}

	@GetMapping(value = "/logoutUser")
	public String logoutUser(HttpSession httpSession) {
		httpSession.invalidate();
		return "login ";
	}

	@PostMapping(value = "/uploadsheet")
	public String uploadsheet(@RequestParam CommonsMultipartFile file,HttpSession session,Model model ) {
		
		String message=	service.uploadSheet(file, session);
		model.addAttribute("msg", message);
	System.out.println(message);
		return "home";

}
}
