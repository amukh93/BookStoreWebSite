package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstoredb.entity.Users;



public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
	}
	
	
	@Test
	public void testCreateUsers() {
		
		Users user = new Users ();
		user.setEmail("testJuniemail@tesdomain1.tst");
		user.setPassword("testJunitPwd1");
		user.setFullName("fullJunitName1");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserDAO userDao = new UserDAO(entityManager);
		user = userDao.create(user);
		entityManager.close();
		entityManagerFactory.close();
	
		assertTrue(user.getUserId()> 0);
		
	}
	
	@Test(expected = PersistenceException.class)
	public void createUserFieldNotSet() {
		
		
		Users user = new Users();
		
		user = userDAO.create(user);
	}
	
	@Test(expected = PersistenceException.class)
	public void testUpdateUsers() {
		Users user =  new Users();
		user.setUserId(5);
		user.setEmail("ramsey.baster@ilovebitches.com");
		user.setFullName("Ramsey Snow");
		user.setPassword("margaya");
		
		user = userDAO.update(user);
		
		entityManagerFactory.close();
		
		assertTrue(user.getUserId()>0);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
