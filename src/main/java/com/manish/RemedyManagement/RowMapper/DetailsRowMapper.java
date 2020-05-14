package com.manish.RemedyManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manish.RemedyManagement.model.Details;

public class DetailsRowMapper implements RowMapper<Details> {

	@Override
	public Details mapRow(ResultSet rs, int arg1) throws SQLException {
		Details d=new Details();
		d.setContact(rs.getString("contact"));
		d.setDob(rs.getDate("dob"));
		d.setFirstName(rs.getString("firstName"));
		d.setGender(rs.getString("gender"));
		d.setId(rs.getInt("id"));
		d.setLastName(rs.getString("lastName"));
		d.setLevel(rs.getString("level"));
		d.setPassword(rs.getString("password"));
		
		return d;
	}
	

}
