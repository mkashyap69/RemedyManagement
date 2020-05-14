package com.manish.RemedyManagement.dao;

import java.util.List;

import com.manish.RemedyManagement.model.Details;
import com.manish.RemedyManagement.model.RemedyList;

public interface RemedyListDao {
	
	int setRemedy(RemedyList list);

	List<RemedyList> getRemdedy();

	int closeRemedy(int remId);

	List<RemedyList> getActiveRemedy(int userId);

	List<RemedyList> getHistoryRemedy(int userId);

	int deleteRemedy(int remId);

	int reopenRemedy(int remId);

	List<RemedyList> getAnalystRemedy(int analystId);

	List<RemedyList> getAdminRemedy();

	int updateCategory(int remId, String category);

	List<Details> getL3Analyst();

	List<Details> getL2Analyst();

	List<Details> getL1Analyst();

	int assignRemedy(int id, int remId);

	int transferRemedy(int id, int remId);
}
