package com.manish.RemedyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manish.RemedyManagement.daoImpl.RemedyListDaoImpl;
import com.manish.RemedyManagement.model.RemedyList;

@Controller
@SessionAttributes({"Id","remId"})
public class AnalystHomeController {
	
	@Autowired
	RemedyListDaoImpl service;
	
	@Autowired
	RemedyList list;
	
	@RequestMapping("/analyst-home")
	public String getAnalystHome(ModelMap model) {
		int analystId=(int) model.get("Id");
		model.put("name", service.getName(analystId));
		return "analyst-home";
	}
	
	@RequestMapping("/analyst-remedy")
	public String getAnalystRemedy(ModelMap model) {
		int analystId=(int) model.get("Id");
		String ret;
		if(service.getAnalystRemedy(analystId).isEmpty()) {
			return "no-issues-analyst";
		}
		else {
		if(service.getAnalystRemedy(analystId)==null)
		{
			ret="session-time-out";
		}
		else {
		model.put("analystRemedyList", service.getAnalystRemedy(analystId));
		ret= "analyst-remedy";
		}
		return ret;
		}
	}
	
	@RequestMapping("/analyst-close")
	public String closeRemedy(@RequestParam int remId) {
		
		service.closeRemedy(remId);
		return "redirect:/analyst-remedy";
	}	
	

	
	@RequestMapping("/get-transfer-remedy")
	public String getTransferRemedy(ModelMap model,@RequestParam int remId) {
		model.put("remId", remId);
		
	
	
		return "redirect:/L1-transfer";
	}
	
	@RequestMapping("/L1-transfer")
	public String transferRemedyL1(ModelMap model) {
		model.put("L1",service.getL1Analyst());
		
	
		return "transfer-remedy-L1";
	}
	
	@RequestMapping("/L2-transfer")
	public String transferRemedyL2(ModelMap model) {
		model.put("L2",service.getL2Analyst());
		
	
		return "transfer-remedy-L2";
	}
	
	@RequestMapping("/L3-transfer")
	public String transferRemedyL3(ModelMap model) {
		model.put("L3",service.getL3Analyst());
		
	
		return "transfer-remedy-L3";
	}
	
	@RequestMapping("/transfer-remedy")
	public String assignRemedy(@RequestParam int id,ModelMap model) {
		int transferRemId=(int) model.get("remId");
		model.put("analystId", id);
		model.put("analystName",service.getAnalystName(id));
	service.transferRemedy(id,transferRemId);
		return "transfer-remedy-notification";
	}
}
