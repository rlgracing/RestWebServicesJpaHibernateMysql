package com.rlg.webservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonMySqlDAO {
	
	private final EntityManager			entityManager;
	private final EntityManagerFactory	entityManagerFactory;

	public PersonMySqlDAO() {
		this.entityManagerFactory	= Persistence.createEntityManagerFactory("persistence_unit_db_test");
		this.entityManager			= entityManagerFactory.createEntityManager();
	}
	
	public void addPerson(PersonMySqlEntity personEntity) {
		this.entityManager.getTransaction().begin();;
		this.entityManager.persist(personEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void deletePerson(Integer id) {
		
		PersonMySqlEntity personEntity = this.getPerson(id);
		
		this.entityManager.getTransaction().begin();;
		this.entityManager.remove(personEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void updatePerson(PersonMySqlEntity personEntity) {
		this.entityManager.getTransaction().begin();;
		this.entityManager.merge(personEntity);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<PersonMySqlEntity> getEverybody() {
		return this.entityManager.createQuery("SELECT pe FROM PersonMySqlEntity pe").getResultList();
	}
	
	public PersonMySqlEntity getPerson(Integer id) {
		return this.entityManager.find(PersonMySqlEntity.class, id);
	}

}
