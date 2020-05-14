/*package com.manish.RemedyManagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.manish.RemedyManagement.daoImpl.DetailsDaoImpl;
import com.manish.RemedyManagement.model.Details;

@RunWith(SpringJUnit4ClassRunner.class)
public class RegControllerTest {
	@Autowired
	DetailsDaoImpl service;
	
	@Autowired
	Details details;
	
	@Autowired
	RegController controller;
	@Autowired
	ModelMap model;

	@Before
	public void setUp() throws Exception {
		 details=new Details();
		service=new DetailsDaoImpl();
	}
	
	@Test
	public void testGetUser() throws Exception {
		assertEquals("user-reg",controller.getUser(model));

	}


	@Test
	public void testGetUserModelMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserModelMapDetailsBindingResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnalyst() throws Exception {
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(new RegController()).build();

		mockMvc.perform(get("/sa-reg")).andExpect(status().isOk()).andExpect(view().name("sa-reg"));
	}
	
	@Test
	public void testGetAnalystModelMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnalystModelMapDetailsBindingResult() {
		fail("Not yet implemented");
	}

}
*/