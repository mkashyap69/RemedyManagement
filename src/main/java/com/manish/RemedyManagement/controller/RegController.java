
package com.manish.RemedyManagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manish.RemedyManagement.daoImpl.DetailsDaoImpl;
import com.manish.RemedyManagement.model.Details;

@Controller
public class RegController {
	@Autowired
	DetailsDaoImpl service;
	
	@InitBinder("details")
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,"dob",new CustomDateEditor(date, false));
		
	}
	
	@RequestMapping("/user-reg")
	public String getUser(ModelMap model) {
		model.addAttribute("details",new Details());
		return "user-reg";
	}
	
	@PostMapping("/user-reg")
	public String getUser(ModelMap model,@Valid Details details,BindingResult result) throws ParseException {
/*		System.out.println(details.getDob());
		int age=service.getAge(details.getDob());
		if(age<18)
		{
			model.put("message","Age shouldn't be less thatn 18");
			return "redirect:/user-reg";
		}
		else {}	
		*/
		if(result.hasErrors())
		{
			return "user-reg";
		}
		service.setDetails(details);
		model.put("id", service.getId(details));
		return "detail-submission-final";
		
	}
	
	@RequestMapping("/sa-reg")
	public String getAnalyst(ModelMap model) {
		model.addAttribute("details",new Details());
		return "sa-reg";
	}

	@PostMapping("/sa-reg")
	public String getAnalyst(ModelMap model,@Valid Details details,BindingResult result) {
		if(result.hasErrors())
		{
			return "sa-reg";
		}
		service.setDetails(details);
		model.put("id", service.getId(details));
		return "detail-submission-final";
	}
}
