package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EProductBean;
import com.dao.EProductDao;

@Controller
public class EProductController {

	@Autowired
	EProductDao productDao;

	@GetMapping("/newproduct") // url->browser
	public String newProduct() {// method name
		return "NewProduct";// jsp name
	}

	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean) {
		// using bean read data ->productBean

		// validation using XX

		// dao insert
		productDao.addProduct(productBean);//argument 
		return "redirect:/products";// X
	}
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<EProductBean> products  = productDao.getAllProducts();//return type 
		
		model.addAttribute("products",products);
		
		return "EcomListProducts";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		productDao.deleteProduct(productId);
		return "redirect:/products";
	}
	
	@GetMapping("/deleteProductByName")
	public String deleteProductByName() {
		return "deleteProductByName";
	}
	@PostMapping("/deleteProductByNameController")
	public String deleteProductByName(@RequestParam("productName") String productName) {
		productDao.deleteWithName(productName);
		return "redirect:/products";
	}

	
	
	
	
	
}
