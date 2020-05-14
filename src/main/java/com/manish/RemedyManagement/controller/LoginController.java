package com.manish.RemedyManagement.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manish.RemedyManagement.daoImpl.DetailsDaoImpl;

@Controller
@SessionAttributes("Id")
public class LoginController {

	@Autowired
	DetailsDaoImpl service;
	
	@InitBinder("details")
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat date=new SimpleDateFormat("yyyy/MM/dd");
		binder.registerCustomEditor(Date.class,"dob",new CustomDateEditor(date, false));
		
	}
	

	@RequestMapping("/")
	public String getIndex() {
		
		return "index";
	}
	
	@PostMapping("/")
	public String getRegistration(@RequestParam("role") String role) {
		String reg=null;
		if(role.equals("User"))
		{
			reg= "redirect:/user-reg";
		}
		else if(role.equals("Analyst"))
		{
			reg= "redirect:/sa-reg";
		}
		else {
			reg= "redirect:/adminlogin";

		}
		return reg;
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		
		return "user-login";
	}
	
	@PostMapping("/login")
	public String getHome(@RequestParam int id,@RequestParam String password,ModelMap model) {
		String home=null;
		model.put("Id",id);
		
		if(password.equals(service.getPassword(id)))
		{
			if(service.getLevel(id).equals("none"))
			{
				home= "redirect:/user-home";
			}
			else
			{
				home="redirect:/analyst-home";
			}
			
		}
		else
		{
			home= "login-error";
		}
		
		return home;
	
	}
	@RequestMapping("/adminlogin")
	public String getAdminLogin() {
		
		return "admin-login";
	}
	
	@PostMapping("/adminlogin")
	public String getAdminHome(@RequestParam int adminId,@RequestParam String password) {
		String home=null;
		if(password.equals(service.getAdminPassword(adminId)))
		{
			home= "admin-home";
		}
		else
		{
			home= "admin-login-error";
		}
		return home;
	}
		
	@RequestMapping("/logout")
	public String Logout() {
	
		return "redirect:/";
	}
	
}
