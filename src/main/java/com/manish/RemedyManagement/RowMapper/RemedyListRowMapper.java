package com.manish.RemedyManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manish.RemedyManagement.model.RemedyList;

public class RemedyListRowMapper implements RowMapper<RemedyList> {

	@Override
	public RemedyList mapRow(ResultSet rs, int rowNum) throws SQLException {
		RemedyList list=new RemedyList();
		list.setAnalystId(rs.getInt("analystId"));
		list.setCategory(rs.getString("category"));
		list.setRemedy(rs.getString("remedy"));
		list.setRemId(rs.getInt("remId"));
		list.setUserId(rs.getInt("userId"));
		list.setUserName(rs.getString("userName"));
		list.setRemedyActive(rs.getBoolean("remedyActive"));;
	    list.setRemedyDate(rs.getDate("remedyDate"));
	    list.setSeatNo(rs.getInt("seatNo"));
	    list.setIPaddress(rs.getString("IPaddress"));
		return list;
	}
	

}
