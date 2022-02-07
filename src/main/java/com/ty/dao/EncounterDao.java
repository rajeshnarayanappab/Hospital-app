package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Person;

public class EncounterDao {


	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	private EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
		return entityManagerFactory.createEntityManager();	
	}
	
	public boolean createEncounter(int branchid,int personid, Encounter encounter) {

		PersonDao personDao = new PersonDao();
		BranchDao branchDao = new BranchDao();
		
		Branch branch = branchDao.getBranchById(branchid);

		Person person = personDao.getPersonById(personid);
		
		if(person != null && branch!= null) {
			
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		encounter.setPerson(person);
		encounter.setBranchs(branch);
		
		entityManager.persist(encounter);

		entityTransaction.commit();
		System.out.println("encounter Saved");
		return true;
		}
		else {
			return false;
		}
	}
	
	public List<Encounter> getAllEncounter(){
		entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Encounter s");
		return query.getResultList();
				
	}
	
	public boolean deleteEncounter(int id) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		Encounter u= entityManager.find(Encounter.class, id);
		if(u!=null) {
			System.out.println("delete method");
			entityTransaction.begin();
			entityManager.remove(u);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public void updateEncounter(Encounter u) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(u);
		entityTransaction.commit();
		
	}
	
	public Encounter getEncounterById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager.find(Encounter.class, id);
	}

public List<Encounter> getEncountersByPersonId(int personid) {
	entityManager=getEntityManager();
	Query query=entityManager.createQuery("select e from Encounter e where e.person.id=?1");
	return query.getResultList();
}
	
}