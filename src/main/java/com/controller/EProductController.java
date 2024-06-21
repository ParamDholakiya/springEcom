package com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EProductBean;
import com.dao.EProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	@WebServlet("/deleteProduct")
	public class DeleteProductServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String idStr = request.getParameter("id");
	        int id = Integer.parseInt(idStr);

	        EProductDao productDAO = new EProductDao();
	        productDAO.deleteProduct(id);
	        
	        // Redirect back to the products list page after deletion
	        response.sendRedirect("redirect:/products");
	    }
	}

	
	
	
	
	
}
