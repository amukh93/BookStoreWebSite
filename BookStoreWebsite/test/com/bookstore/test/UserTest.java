package com.bookstore.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity2.Users;

public class UserTest {

	public static void main(String[] args) {
		
		
		Users user = new Users ();
		user.setEmail("tesemail@tesdomain.tst");
		user.setPassword("testPwd");
		user.setFullName("fullName");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
