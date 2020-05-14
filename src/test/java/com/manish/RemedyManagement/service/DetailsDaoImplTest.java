package com.manish.RemedyManagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.manish.RemedyManagement.RowMapper.DetailsRowMapper;
import com.manish.RemedyManagement.daoImpl.DetailsDaoImpl;
import com.manish.RemedyManagement.model.Details;
import com.manish.RemedyManagement.util.DateUtil;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ComponentScan(basePackages="com.manish.RemedyManagement.*")
public class DetailsDaoImplTest {
	

	@Mock 
	DateUtil date;
	
	
	@Mock
	JdbcTemplate jdbcTemplate;
	@Mock
	Details analyst,user;
	
	@InjectMocks
	DetailsDaoImpl service;
	
	@Mock
	List<Details> list;
	
	@Mock
	DetailsRowMapper rowMapper;
	
	
	
	@Before
	public void setUp() throws Exception {
		
	
		
		 list=new ArrayList<>();
		 
		 rowMapper=new DetailsRowMapper();
		 
		 analyst=new Details();
		 
		analyst=new Details("Manish","Kumar","987456123",1,"Manish123",new Date(),"Male",
				"L1");
		
		user=new Details("Manish","Kashyap","987456123",2,"Manish@123",new Date(),"Male",
				"none");
	list.add(analyst);
	list.add(user);
	
	}

	@Test
	public void testGetDetails() {
	
		when(jdbcTemplate.query(Mockito.any(String.class),Mockito.any(DetailsRowMapper.class))).thenReturn(list);

	
		

		assertEquals(list,service.getDetails());

		

	} 

	@Test
	public void testSetDetails() {
		when(service.setDetails(analyst)).thenReturn(1);

		assertEquals(1,service.setDetails(analyst));
	
		
	}

	@Test
	public void testGetPassword() {
		when(service.getPassword(2)).thenReturn("Manish@123");
		assertEquals("Manish@123",service.getPassword(2));
	}

	@Test
	public void testGetLevel() {
		when(service.getLevel(1)).thenReturn("L1");
		assertEquals("L1",service.getLevel(1));
	}


}
