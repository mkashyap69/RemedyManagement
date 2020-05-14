package com.manish.RemedyManagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manish.RemedyManagement.daoImpl.RemedyListDaoImpl;
import com.manish.RemedyManagement.model.RemedyList;

@Controller
@SessionAttributes("Id")
public class UserHomeController {
	
	@Autowired
	RemedyListDaoImpl service;
	
	@Autowired
	RemedyList list;
	
	@RequestMapping("/user-home")
	public String getUserHome(ModelMap model) {
		int userId=(int) model.get("Id");
		model.put("name", service.getName(userId));
		return "user-home";
	}	
	
	
	@RequestMapping("/add-remedy")
	public String getAddRemedy(ModelMap model) {

		int userId=(int) model.get("Id");
		model.put("userId", userId);
		model.addAttribute("list", new RemedyList());
		return "add-remedy";
	}	
	
	@PostMapping("/add-remedy")
	public String addRemedy(ModelMap model, @Valid @ModelAttribute("list") RemedyList list,Errors error)
	{
		if(error.hasErrors())
		{
			return "add-remedy";
		}
		service.setRemedy(list);
		model.put("list",list);
		return "add-remedy-notification";
	}


	@RequestMapping("/active-remedy")
	public String getActiveRemedy(ModelMap model) {
		int userId=(int) model.get("Id");
		String ret;
		if(service.getActiveRemedy(userId).isEmpty()) {
			return "no-issues-user";		
			}
		else {
		if(service.getActiveRemedy(userId)==null)
		{
		ret="session-time-out";	
		}
		else {
			model.put("remedyList", service.getActiveRemedy(userId));
			ret= "active-remedy";
		}
		return ret;
		}
	}	
	
	@RequestMapping("/close")
	public String closeRemedy(@RequestParam int remId) {
		
		service.closeRemedy(remId);
		return "redirect:/active-remedy";
	}	
	
	@RequestMapping("/history")
	public String getHistoryRemedy(ModelMap model) {
		int userId=(int) model.get("Id");
		String ret;
		if(service.getHistoryRemedy(userId).isEmpty()) {
			return "no-issues-user";
		}
		else {
		if(service.getHistoryRemedy(userId)==null)
		{
			ret="session-time-out";
		}
		else
		{
		model.put("historyRemedyList", service.getHistoryRemedy(userId));
		ret= "user-remedy-history";
		}
		return ret;
		}
	}	
	
    
	@RequestMapping("/delete")
	public String deleteRemedyFromHistory(@RequestParam int remId) {
		
		service.deleteRemedy(remId);
		return "redirect:/history";
	}	
	
	@RequestMapping("/reopen")
	public String reopenRemedyFromHistory(@RequestParam int remId) {
		
		service.reopenRemedy(remId);
		return "redirect:/history";
	}	
	
	
	@RequestMapping("/search-by-id")
	public String searchRemedyFromHistory(@RequestParam int remId,ModelMap model) {
		int userId=(int) model.get("Id");
		if(service.searchRemedyById(remId,userId).isEmpty())
		{
			return "no-history";
		}
		else {
		model.put("searchById",service.searchRemedyById(remId,userId));
		return "user-remedy-history-id";
		}
	}	
	
	@RequestMapping("/search-by-id-active")
	public String searchRemedyFromActive(@RequestParam int remId,ModelMap model) {
		int userId=(int) model.get("Id");
		if(service.searchRemedyByIdActive(remId,userId).isEmpty())
		{
			return "no-history";
		}
		else {
		model.put("searchById",service.searchRemedyByIdActive(remId,userId));
		return "active-remedy-id";
		}
	}	
	
	@RequestMapping("/sort-by-id")
	public String sortByIdHistory(ModelMap model) {
		int userId=(int) model.get("Id");
		if(service.getHistoryRemedyOrderById(userId).isEmpty()) {
			return "no-items-to-sort";
		}
		else {
		model.put("sortid",service.getHistoryRemedyOrderById(userId));
		return "sort-by-id";
		}
	}	
	
	@RequestMapping("/sort-by-date")
	public String sortByDateHistory(ModelMap model) {
		int userId=(int) model.get("Id");
		if(service.getHistoryRemedyOrderByDate(userId).isEmpty()) {
			return "no-items-to-sort";
		}
		else {
		model.put("sortdate",service.getHistoryRemedyOrderByDate(userId));
		
		return "sort-by-date";
		}
	}
	
	
	@RequestMapping("/sort-by-id-active")
	public String sortByIdActive(ModelMap model) {
		int userId=(int) model.get("Id");
		if(service.getActiveRemedyOrderById(userId).isEmpty()) {
			return "no-items-to-sort";
		}
		else {
		model.put("sortid",service.getActiveRemedyOrderById(userId));
		return "sort-by-id";
		}
	}	
	
	@RequestMapping("/sort-by-date-active")
	public String sortByDateActive(ModelMap model) {
		int userId=(int) model.get("Id");
		if(service.getActiveRemedyOrderByDate(userId).isEmpty()) {
			return "no-items-to-sort";
		}
		else {
		model.put("sortdate",service.getActiveRemedyOrderByDate(userId));
		
		return "sort-by-date";
		}
	}
}
