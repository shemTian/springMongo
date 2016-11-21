package com.tsq.controller.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping("/error/5xx")
	public String getPerson(Model model,HttpServletRequest request){
		return "error/5xx";
	}
	@RequestMapping("/error/test")
	public ResponseEntity errorTest(Model model,HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("");
	}
}
