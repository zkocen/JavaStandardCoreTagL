package com.worldmanager.models;

import java.io.Serializable;

public class WebUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String uid;
	private String pwd;
	private int authLevel;

	public WebUser() {}

	public String getUserId() {
		return uid;
	}

	public void setUserId(String value) {
		uid = value;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String value) {
		pwd = value;
	}

	public int getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(int value) {
		authLevel = value;
	}

	@Override
	public String toString() {
		return "WebUser [uid=" + uid + ", pwd=" + pwd + ", authLevel="
				+ authLevel + "]";
	}
}
