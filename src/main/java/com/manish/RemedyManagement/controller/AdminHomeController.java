package com.manish.RemedyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manish.RemedyManagement.daoImpl.RemedyListDaoImpl;
import com.manish.RemedyManagement.model.RemedyList;

@Controller
@SessionAttributes("remId")
public class AdminHomeController {

	@Autowired
	RemedyListDaoImpl service;
	
	@Autowired
	RemedyList list;
	
	@RequestMapping("/admin-home")
	public String getAdminHome() {
		return "admin-home";
	}	
	
	@RequestMapping("/admin-remedy")
	public String getAdminRemedy(ModelMap model) {
		String ret;
		if(service.getAdminRemedy().isEmpty()) {
			return "no-issues-admin";
		}
		else {
		if(service.getAdminRemedy()==null) {
			ret="session-time-out";
		}
		else {
		model.put("adminRemedyList", service.getAdminRemedy());
		ret= "admin-remedy";
		}
		return ret;
		}
	}	
	
	@RequestMapping("/admin-close")
	public String closeRemedy(@RequestParam int remId) {
		
		service.closeRemedy(remId);
		return "redirect:/admin-remedy";
	}	
	
	@RequestMapping("/update-remedy")
	public String getUpdateRemedy(@RequestParam int remId,ModelMap model) {
		
		model.put("remId", remId);
		return "update-remedy";
	}	
	
	@PostMapping("/update-remedy")
	public String updateRemedy(ModelMap model,@RequestParam String category ) {
		
		int remId=(int) model.get("remId");

		service.updateCategory(remId,category);
		return "update-remedy-notification";
	}	
	
	@RequestMapping("/get-assign-remedy")
	public String getAssignRemedy(ModelMap model,@RequestParam int remId) {
		model.put("remId", remId);
		
	
	
		return "redirect:/L1";
	}
	
	@RequestMapping("/L1")
	public String assignRemedyL1(ModelMap model) {
		model.put("L1",service.getL1Analyst());
		
	
		return "assign-remedy-L1";
	}
	
	@RequestMapping("/L2")
	public String assignRemedyL2(ModelMap model) {
		model.put("L2",service.getL2Analyst());
		
	
		return "assign-remedy-L2";
	}
	
	@RequestMapping("/L3")
	public String assignRemedyL3(ModelMap model) {
		model.put("L3",service.getL3Analyst());
		
	
		return "assign-remedy-L3";
	}
	
	@RequestMapping("/assign-remedy")
	public String assignRemedy(@RequestParam int id,ModelMap model) {
		int assignRemId=(int) model.get("remId");
		model.put("analystId", id);
		model.put("analystName",service.getAnalystName(id));
	service.assignRemedy(id,assignRemId);
		return "assign-remedy-notification";
	}
}
