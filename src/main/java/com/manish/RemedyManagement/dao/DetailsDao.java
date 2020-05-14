package com.manish.RemedyManagement.dao;

import java.util.List;

import com.manish.RemedyManagement.model.Details;

public interface DetailsDao {

	String getAdminPassword(int adminId);

	String getLevel(int id);

	String getPassword(int id);

	int setDetails(Details det);

	List<Details> getDetails();

	int getId(Details det);

}
