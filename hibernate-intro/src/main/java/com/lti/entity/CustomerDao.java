package com.lti.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerDao {
	
	public void databaseAdd(Customer customer) {
		
		//Step1. Load/create entity/ManagerFactory object
		//During this step, META-INF Persistence.xml is read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
		//Step2. Load/Create EntityManager Object
		EntityManager em = emf.createEntityManager();
		
		//Step3. Start/Participate in a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever we want
		em.persist(customer); //persist method generates insert query
		
		tx.commit();
		
		//below code should be in finally block
		em.close();
		emf.close();
		
		
	}
	
public Customer databaseShow(int custId) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em = emf.createEntityManager();
		
		//find method generates select query
		Customer c = em.find(Customer.class, custId); //1st parameter is table name
		
		
		em.close();
		emf.close();
		
		return c;
		
	}
public void databaseUpdate(Customer customer) {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	
	em.merge(customer);
	
	tx.commit();
	
	em.close();
	emf.close();
	
	
}
	

}