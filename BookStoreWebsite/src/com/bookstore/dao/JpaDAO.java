package com.bookstore.dao;

import javax.persistence.EntityManager;

public class JpaDAO<E> {
	
	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public E create(E e) {
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.flush();
		entityManager.refresh(e); 
		entityManager.getTransaction().commit();
		entityManager.close();
		return e;
	}
	
	public E update(E e) {
		entityManager.getTransaction().begin();
		e= entityManager.merge(e);
		entityManager.getTransaction().commit();
		entityManager.close();
		return e;
	}
	
	
}
