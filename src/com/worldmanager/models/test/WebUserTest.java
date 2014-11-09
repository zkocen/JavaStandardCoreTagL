package com.worldmanager.models.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.worldmanager.models.WebUser;

public class WebUserTest {

	WebUser wu;
	String uid = "authorized_user";
	String pwd = "presta123";
	int authLevel = 19;
	
	@Before
	public void setUp() throws Exception {
		wu = new WebUser();
		wu.setUserId(uid);
		wu.setPassword(pwd);
		wu.setAuthLevel(authLevel);
	}

	@Test
	public void testConstructor() {
		assertNotNull("Default constructor not working for WebUser");
	}
	
	@Test
	public void testMutatorsAndAccessors() {
		assertEquals("value not set correcty for uid", uid, wu.getUserId());
		assertEquals("value not set correcty for pwd", pwd, wu.getPassword());
		assertEquals("value not set correcty for auth level", authLevel, wu.getAuthLevel());
	}
	
	@Test
	public void testToString() {
		String retStr = wu.toString();
		assertTrue("ToString does not contain uid", retStr.contains(uid));
		assertTrue("ToString does not contain pwd", retStr.contains(pwd));
		assertTrue("ToString does not contain catalog", retStr.contains(String.format("%d", authLevel)));
	}
}
