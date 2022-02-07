package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Hospital;


public class HospitalDao {


	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	private EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
		return entityManagerFactory.createEntityManager();	
	}
	
	
	public boolean saveHospital(Hospital hospital) {
		
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return true;
		
	}
	
	public List<Hospital> getAllHospital(){
		entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Hospital s");
		return query.getResultList();
				
	}
	
	public boolean deleteHospital(int id) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		Hospital u= entityManager.find(Hospital.class, id);
		if(u!=null) {
			System.out.println("delete method");
			entityTransaction.begin();
			entityManager.remove(u);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public void updateHospital(Hospital u) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(u);
		entityTransaction.commit();
		
	}
	
	public Hospital getHospitalById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager.find(Hospital.class, id);
	}

}