package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Person;

public class PersonDao {
	

	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	private EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
		return entityManagerFactory.createEntityManager();	
	}
	
	
	public boolean savePerson(Person person) {
		
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		System.out.println("Person Saved");
		return true;
		
	}
	
	public List<Person> getAllPerson(){
		entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Person s");
		return query.getResultList();
				
	}
	
	public boolean deletePerson(int id) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		Person u= entityManager.find(Person.class, id);
		if(u!=null) {
			System.out.println("delete method");
			entityTransaction.begin();
			entityManager.remove(u);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public void updatePerson(Person u) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(u);
		entityTransaction.commit();
		
	}
	
	public Person getPersonById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager.find(Person.class, id);
	}
	
	
}