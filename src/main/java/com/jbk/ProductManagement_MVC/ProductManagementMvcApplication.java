package com.jbk.ProductManagement_MVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class ProductManagementMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementMvcApplication.class, args);
	}
	
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		return new  CommonsMultipartResolver();
	}
	

}
