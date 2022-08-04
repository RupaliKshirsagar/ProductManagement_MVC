package com.jbk.ProductManagement_MVC.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.ProductManagement_MVC.entity.Product;
//import com.jbk.ProductManagement_MVC.entity.User;
//import com.jbk.ProductManagement_MVC.entity.User;
import com.jbk.ProductManagement_MVC.service.ProductService;
//import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class ProductController {

	@Autowired
	 private ProductService service;
	
	
	@PostMapping(value="/addProduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		ModelAndView mv=new ModelAndView();
		
		Product prod=service.addProduct(product);
		
		
		if(prod!=null) {
		
			mv.setViewName("addProduct");
			mv.addObject("msg", "Product Added Successfully");
		
		}else {
			mv.setViewName("addProduct");
			mv.addObject("msg", "Product Not Added");
		}
	return mv;
}
	
	@GetMapping(value = "/productList")
	public String productList(Model model) {
		List<Product> productList = service.productList();
//		for (Product pro : products) {
//			System.out.println(pro);
//		}
		model.addAttribute("productList", productList);
		return "productList";

	}
//	@RequestMapping(value="productList")
//	public ModelAndView productList() {
//		
//		List<Product> prodList=service.productList();
//		ModelAndView mv =new ModelAndView();
//		mv.setViewName("productList");
//		mv.addObject("product", prodList);
//		return mv;
//	}

	@PostMapping(value = "/uploadProducts")
	public String uploadsheet(@RequestParam CommonsMultipartFile file,HttpSession session,Model model ) {
		System.out.println(session);
		String msg=	service.uploadSheet(file,session);
		model.addAttribute("msg", msg);
	System.out.println(msg);
		return "home";

}

//	@RequestMapping(value="getProductList")
//	public ModelAndView displayProductList() {
//		
//		List<Product> prodList=service.productList();
//		ModelAndView mv =new ModelAndView();
//		mv.setViewName("listOfProduct");
//		mv.addObject("product", prodList);
//		return mv;
//		
//	}
	
	
}
