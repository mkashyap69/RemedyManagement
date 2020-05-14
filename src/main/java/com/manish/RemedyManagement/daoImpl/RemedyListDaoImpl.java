package com.manish.RemedyManagement.daoImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.manish.RemedyManagement.RowMapper.DetailsRowMapper;
import com.manish.RemedyManagement.RowMapper.RemedyListRowMapper;
import com.manish.RemedyManagement.dao.RemedyListDao;
import com.manish.RemedyManagement.model.Details;
import com.manish.RemedyManagement.model.RemedyList;
import com.manish.RemedyManagement.util.DateUtil;

@Service
public class RemedyListDaoImpl implements RemedyListDao {

	@Autowired
	DateUtil date;
	
	@Autowired
	RemedyList list;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int setRemedy(RemedyList list) {
		String query="insert into RemedyList(userId,userName,remedyDate,remedy,category,remedyActive,seatNo,IPaddress) values(?,?,?,?,?,?,?,?)";
		int affected=jdbcTemplate.update(query,list.getUserId(),list.getUserName(),date.convertToDateTimeString(new Date()),list.getRemedy(),list.getCategory(),list.isRemedyActive(),list.getSeatNo(),list.getIPaddress());
		return affected;
	}

	@Override
	public List<RemedyList> getRemdedy() {
        String query="select * from RemedyList";
		
		return jdbcTemplate.query(query,new RemedyListRowMapper());
	}
	
	@Override
	public List<RemedyList> getActiveRemedy(int userId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and userId=?";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),true,userId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}

	@Override
	public int closeRemedy(int remId) {
		String query="update RemedyList set remedyActive=? where remId=?";
		int affected=jdbcTemplate.update(query,false,remId);
		return affected;
		
	}
	
	@Override
	public List<RemedyList> getHistoryRemedy(int userId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and userId=?";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),false,userId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}

	@Override
	public int deleteRemedy(int remId) {
		String query="delete from RemedyList where remId=?";
		int affected=jdbcTemplate.update(query,remId);
		return affected;
		
	}
	@Override
	public int reopenRemedy(int remId) {
		String query="update RemedyList set remedyActive=? where remId=?";
		int affected=jdbcTemplate.update(query,true,remId);
		return affected;
		
	}

	@Override
	public List<RemedyList> getAnalystRemedy(int analystId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and analystId=?";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),true,analystId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}

	@Override
	public List<RemedyList> getAdminRemedy() {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and  analystId is null";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),true);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	
	}

	@Override
	public int updateCategory(int remId,String category) {
		String query="update RemedyList set category=? where remId=?";
		int affected=jdbcTemplate.update(query,category,remId);
		return affected;
		
	}
	
	@Override
	public List<Details> getL1Analyst() {
		String query="select * from user_analyst where level=?";
		String level="L1";
		return jdbcTemplate.query(query,new DetailsRowMapper(),level);
	}
	
	@Override
	public List<Details> getL2Analyst() {
		String query="select * from user_analyst where level=?";
		String level="L2";
		return jdbcTemplate.query(query,new DetailsRowMapper(),level);
	}
	
	@Override
	public List<Details> getL3Analyst() {
		String query="select * from user_analyst where level=?";
		String level="L3";
		return jdbcTemplate.query(query,new DetailsRowMapper(),level);
	}

	@Override
	public int assignRemedy(int id,int remId) {
		String query="update RemedyList set analystId=? where remId=?";
		int affected=jdbcTemplate.update(query,id,remId);
		return affected;
	}

	@Override
	public int transferRemedy(int id,int remId) {
		String query="update RemedyList set analystId=? where remId=?";
		int affected=jdbcTemplate.update(query,id,remId);
		return affected;
	}

	public String getAnalystName(int id) {
		String query="select firstName from user_analyst where id=?";
			String name=(String)jdbcTemplate.queryForObject(query, new Object[] {id},String.class);
		return name;
	}

	public List<RemedyList> searchRemedyById(int remId,int userId) {
		String query="select * from remedylist where remId=? and  userId=? and remedyActive=?";
		List<RemedyList> list=jdbcTemplate.query(query, new RemedyListRowMapper(),remId,userId,false);
		return list;
		
		
	}
	
	public List<RemedyList> searchRemedyByIdActive(int remId,int userId) {
		String query="select * from remedylist where remId=? and  userId=? and remedyActive=?";
		List<RemedyList> list=jdbcTemplate.query(query, new RemedyListRowMapper(),remId,userId,true);
		return list;
		
		
	}


	public List<RemedyList> getHistoryRemedyOrderById(int userId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and userId=? order by remId desc";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),false,userId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}
	
	public List<RemedyList> getHistoryRemedyOrderByDate(int userId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and userId=? order by remedyDate desc";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),false,userId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}
	
	public List<RemedyList> getActiveRemedyOrderById(int userId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and userId=? order by remId desc";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),true,userId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}
	
	public List<RemedyList> getActiveRemedyOrderByDate(int userId) {
		List<RemedyList>list;
        try {
			String query="select * from RemedyList where remedyActive=? and userId=? order by remedyDate desc";
			
			list= jdbcTemplate.query(query,new RemedyListRowMapper(),true,userId);
		} catch (NullPointerException e) {
			list=null;
		}
        return list;
	}
	
	public String getName(int id) {
		String query="select firstName from user_analyst where id=?";
		String name=jdbcTemplate.queryForObject(query, new Object[] {id},String.class);
		return name;
	}
}
