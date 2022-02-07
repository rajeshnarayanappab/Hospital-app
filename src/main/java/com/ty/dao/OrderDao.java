package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Encounter;
import com.ty.dto.MedOrder;

public class OrderDao {


	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	private EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
		return entityManagerFactory.createEntityManager();	
	}
	
	
	public boolean createMedOrder(int encounterid, MedOrder medorder) {

		EncounterDao encounterDao = new EncounterDao();
		
		Encounter encounter = encounterDao.getEncounterById(encounterid);
		
		if(encounter != null) {
			
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		medorder.setEncounter(encounter);
		
		entityManager.persist(medorder);

		entityTransaction.commit();
		System.out.println("medorder Saved");
		return true;
		}
		else {
			return false;
		}
	}
	
	public List<MedOrder> getAllOrder(){
		entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from MedOrder s");
		return query.getResultList();
				
	}
	
	public boolean deleteOrder(int id) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		MedOrder u= entityManager.find(MedOrder.class, id);
		if(u!=null) {
			System.out.println("delete method");
			entityTransaction.begin();
			entityManager.remove(u);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public void updateOrder(MedOrder u) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(u);
		entityTransaction.commit();
		
	}
	
	public MedOrder getOrderById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager.find(MedOrder.class, id);
	}
	
	
}