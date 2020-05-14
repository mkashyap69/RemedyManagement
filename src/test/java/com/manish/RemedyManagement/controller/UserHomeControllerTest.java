package com.manish.RemedyManagement.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;

import com.manish.RemedyManagement.model.RemedyList;

@SpringBootTest
public class UserHomeControllerTest {
	
	
	UserHomeController controller;
	ModelMap model;
	Errors error;

	@Before
	public void setUp() throws Exception {
		controller=new UserHomeController();
		model=new ModelMap();
		
	}

/*	@Test
	public void testGetUserHome() {
		
		assertEquals("user-home",controller.getUserHome());
	}*/

	/*@Test
	public void testGetAddRemedy() {
		assertEquals("add-remedy",controller.getAddRemedy(model));
	}

	@Test
	public void testAddRemedy() {
		assertEquals("add-remedy",controller.addRemedy(model,new RemedyList(),error));
	}

	@Test
	public void testGetActiveRemedy() {
		assertEquals("ret",controller.getAddRemedy(model));
	}

	@Test
	public void testCloseRemedy() {
		int remId = 1;
		assertEquals("redirect:/active-remedy",controller.closeRemedy( remId));
	}
*/
}
