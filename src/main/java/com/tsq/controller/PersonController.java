package com.tsq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsq.model.Person;
import com.tsq.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	PersonService personService;
	@RequestMapping("/getPerson")
	public String getPerson(Model model,HttpServletRequest request){
		model.addAttribute("personList", personService.getPersonPage(1, 10));
		return "person/pageList";
	}
	@RequestMapping("/modifyPerson")
	public String modifyPerson(Model model,HttpServletRequest request,@ModelAttribute Person person){
		personService.modifyPerson(person);
		model.addAttribute("personList", personService.getPersonPage(1, 10));
		return "person/pageList";
	}
	@RequestMapping("/destoryPerson")
	public String destoryPerson(Model model,HttpServletRequest request){
		model.addAttribute("personList", personService.getPersonPage(1, 10));
		return "person/pageList";
	}
	@RequestMapping("/newPerson")
	public String newPerson(Model model,HttpServletRequest request,Person person){
		personService.createPerson(person);
		model.addAttribute("personList", personService.getPersonPage(1, 10));
		return "person/pageList";
	}
	@RequestMapping("/regist")
	public String regist(Model model,HttpServletRequest request){
		return "person/regist";
	}
}
