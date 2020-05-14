package com.manish.RemedyManagement.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.manish.RemedyManagement.daoImpl.DetailsDaoImpl;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(LoginController.class)
public class TestLoginController {

	@Mock
	DetailsDaoImpl service;
	
	@InjectMocks
	LoginController controller;
	
	MockMvc mockMvc;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		service=new DetailsDaoImpl();
		mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
	}
	

	@Test
	public void testGetIndex() throws Exception{
		
		

		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	
	}
	

	@Test
    public void testGetRegistrationUser() throws Exception {


		mockMvc.perform(post("/").param("role", "User"))
		.andExpect(status().isOk())
        .andExpect(view().name("redirect:/user-reg"));
		

	}
	
	@Test
    public void testGetRegistrationAnalyst() throws Exception {


		mockMvc.perform(post("/").param("role", "Analyst"))
		.andExpect(status().isOk())
        .andExpect(view().name("redirect:/sa-reg"));
		

	}
	@Test
    public void testGetRegistrationAdmin() throws Exception {


		mockMvc.perform(post("/").param("role", "Admin"))
		.andExpect(status().isOk())
        .andExpect(view().name("redirect:/adminlogin"));
		

	}
	

	
	@Test
	public void testGetLogin() throws Exception {
	

		mockMvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("user-login"));
	}

	
	
	@Test
	public void testLoginPostUser() throws Exception{
		
		
		mockMvc.perform(post("/login")
	            .param("id", "1")
	            .param("password","Manish@123"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("login-error"));
	}
	
	@Test
	public void testLoginPostAnalyst() throws Exception{
		mockMvc.perform(post("/login")
	            .param("id", "2")
	            .param("password", Mockito.anyString()))
		       .andExpect(status().isOk())
		       .andExpect(view().name("login-error"));
	}


	
	@Test
	public void testGetAdminLogin() throws Exception {

		mockMvc.perform(get("/adminlogin"))
		.andExpect(status().isOk())
		.andExpect(view().name("admin-login"));
	
	}

	

	@Test
	public void testLoginPostAdmin() throws Exception{
		
		mockMvc.perform(post("/adminlogin")
	            .param("adminId", "1")
	            .param("password",Mockito.anyString()))
		       .andExpect(status().isOk())
		       .andExpect(view().name("admin-login-error"));
	}
	
	@Test
	public void testLogout() throws Exception {

		mockMvc.perform(get("/logout"))
		.andExpect(status().isOk())
        .andExpect(view().name("redirect:/"));
	}

}
