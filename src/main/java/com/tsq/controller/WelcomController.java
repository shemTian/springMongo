package com.tsq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {
	@RequestMapping("/index")  
	public String regist(Model model,HttpServletRequest request){
		return "index";
	}
}
