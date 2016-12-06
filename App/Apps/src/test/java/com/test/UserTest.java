package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junl.apps.service.users.IUsers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext_db.xml", "/spring/applicationContext.xml" })
public class UserTest {

	@Autowired
	private IUsers service;
	
	@Test
	public void test() throws Exception {
		
		System.out.println(service.doLogin());
	}
}
