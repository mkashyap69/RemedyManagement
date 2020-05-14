
package com.manish.RemedyManagement.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.manish.RemedyManagement.RowMapper.DetailsRowMapper;
import com.manish.RemedyManagement.dao.DetailsDao;
import com.manish.RemedyManagement.model.Details;
import com.manish.RemedyManagement.util.DateUtil;

@Service
public class DetailsDaoImpl implements DetailsDao {
	
	@Autowired
	DateUtil date;

	@Autowired
	Details det;
	@Autowired
	DetailsDao dao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Details> getDetails() {
		String query="select * from user_analyst";
		
		return jdbcTemplate.query(query,new DetailsRowMapper());
	}

	@Override
	public int setDetails(Details det) {
		String query="insert into user_analyst (firstName,lastName,contact,password,dob,gender,level) values(?,?,?,?,?,?,?)";
		int affected=jdbcTemplate.update(query,det.getFirstName(),det.getLastName(),det.getContact(),det.getPassword(),date.convertToDateString(det.getDob()),det.getGender(),det.getLevel());
		return affected;
		
	}
	
	
 
	@Override
	public String getPassword(int id) {
		
		String password;
		try {
			String query="select password from user_analyst where id=?";
			password = (String)jdbcTemplate.queryForObject(query, new Object[] {id},String.class);
		} catch (EmptyResultDataAccessException e) {
		
			password= "NULL";
		}
		return password;
	}
	

	@Override
  public String getLevel(int id)
  {
	 
	 
		 String query="select level from user_analyst where id=?";
		String level=(String) jdbcTemplate.queryForObject(query,new Object[] {id},String.class);
	  
	  return level;
  }
	
	@Override
	  public int getId(Details det)
	  {
		 
		 
			 String query="select id from user_analyst where password=?";
			int id=(Integer) jdbcTemplate.queryForObject(query,new Object[] {det.getPassword()},Integer.class);
		  
		  return id;
	  }
	
	@Override
	public String getAdminPassword(int adminId) {
		String password;
		try {
			String query="select password from admin where adminId=?";
			password = (String)jdbcTemplate.queryForObject(query, new Object[] {adminId},String.class);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Sorry for the error");
			password= "NULL";
		}
		return password;
	}

/*	public int getAge(Date dob) throws ParseException {
		Date currentDate=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");                           
	    int d1 = Integer.parseInt(formatter.format(dob));                            
	    int d2 = Integer.parseInt(formatter.format(currentDate));                          
	    int age = (d2 - d1) / 10000;                                                       
	    return age;        
	}
	
*/
	
}
