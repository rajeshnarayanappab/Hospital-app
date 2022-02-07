package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Item;
import com.ty.dto.MedOrder;

public class ItemDao {


	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	private EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
		return entityManagerFactory.createEntityManager();	
	}
	
	
	public boolean createItem(int medorderid, Item item) {

		OrderDao medOrderDao = new OrderDao();
		
		MedOrder medorder  = medOrderDao.getOrderById(medorderid);
		
		if(medorder != null) {
			
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		item.setMedOrder(medorder);
		
		entityManager.persist(item);

		entityTransaction.commit();
		System.out.println("item Saved");
		return true;
		}
		else {
			return false;
		}
	}
	
	public List<Item> getAllItem(){
		entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Item s");
		return query.getResultList();
				
	}
	
	public boolean deleteItem(int id) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		Item u= entityManager.find(Item.class, id);
		if(u!=null) {
			System.out.println("delete method");
			entityTransaction.begin();
			entityManager.remove(u);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public void updateItem(Item u) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(u);
		entityTransaction.commit();
		
	}
	
	public Item getItemById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager.find(Item.class, id);
	}
	
	
}