package com.manish.RemedyManagement.model;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class RemedyList {
	
	
	private int userId;
	private int analystId;
	private int remId;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	@Size(max=500, message="*Required!!! Please don't exceed 500 words")
	private String remedy;
	
	@NotEmpty(message="*Required")
	private String category;
	
	private boolean remedyActive;
	
	private Date remedyDate;
	
	@NotNull(message="*Required")
	private int seatNo;
	
	@NotEmpty(message="*Required")
	private String IPaddress;
	public RemedyList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RemedyList(int userId, String userName, String remedy, String category,
			boolean remedyActive, int seatNo, String iPaddress) {
		super();
		this.userId = userId;
		this.analystId = analystId;
		this.remId = remId;
		this.userName = userName;
		this.remedy = remedy;
		this.category = category;
		this.remedyActive = remedyActive;
		this.remedyDate = remedyDate;
		this.seatNo = seatNo;
		IPaddress = iPaddress;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAnalystId() {
		return analystId;
	}
	public void setAnalystId(int analystId) {
		this.analystId = analystId;
	}
	public int getRemId() {
		return remId;
	}
	public void setRemId(int remId) {
		this.remId = remId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRemedy() {
		return remedy;
	}
	public void setRemedy(String remedy) {
		this.remedy = remedy;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isRemedyActive() {
		return remedyActive;
	}
	public void setRemedyActive(boolean remedyActive) {
		this.remedyActive = remedyActive;
	}
	public Date getRemedyDate() {
		return remedyDate;
	}
	public void setRemedyDate(Date remedyDate) {
		this.remedyDate = remedyDate;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public String getIPaddress() {
		return IPaddress;
	}


	public void setIPaddress(String iPaddress) {
		IPaddress = iPaddress;
	}


	@Override
	public String toString() {
		return "RemedyList [userId=" + userId + ", analystId=" + analystId + ", remId=" + remId + ", userName="
				+ userName + ", remedy=" + remedy + ", category=" + category + ", remedyActive=" + remedyActive
				+ ", remedyDate=" + remedyDate + ", seatNo=" + seatNo + ", IPaddress=" + IPaddress + "]";
	}
	
	
	
	
	

}
