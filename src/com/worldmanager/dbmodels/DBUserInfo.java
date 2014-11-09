package com.worldmanager.dbmodels;


public class DBUserInfo {

	private String uid;
	private String pwd;
	private String cat;
	
	public DBUserInfo(){}
	
	public DBUserInfo(String userID, String password, String catalog) {
		uid = userID;
		pwd = password;
		cat = catalog;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String value) {
		uid = value;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String value) {
		pwd = value;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String value) {
		cat = value;
	}
}
