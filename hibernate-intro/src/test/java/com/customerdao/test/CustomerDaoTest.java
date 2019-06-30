package com.customerdao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

public class CustomerDaoTest {

	@Test
	public void testAdd() {
		Customer c = new Customer();
		c.setName("Siddhant");
		c.setEmail("sdg@narad.com");
		c.setCity("NCR");
	
		//c.setDateOfBirth("");
		
		CustomerDao dao = new CustomerDao();
		dao.databaseAdd(c);
	}
	
	@Test
	public void testFetch() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databaseShow(1);
		
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
	}
	
	@Test
	public void testUpdate() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databaseShow(3);
		cust.setCity("Chennai");
		dao.databaseUpdate(cust);
	}

}
