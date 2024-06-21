package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EUserBean;
import com.dao.EUserDao;

 
@Controller
public class EcomSessionController {

	@Autowired
	EUserDao userDao;
	
	
	@GetMapping("/esignup")
	public String signup() {
		return "EcomSignup"; 
	}

	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) {
		//jsp form -> controller -> 
		
		//validation 
		
		//insert  	
		userDao.insertUser(userBean);
		return "EcomLogin";
	}
}
