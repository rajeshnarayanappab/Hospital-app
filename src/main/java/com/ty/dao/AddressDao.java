package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Address;
import com.ty.dto.Branch;

public class AddressDao {

		EntityManager entityManager;
		EntityTransaction entityTransaction;
		
		private EntityManager getEntityManager() {
			
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
			return entityManagerFactory.createEntityManager();	
		}
		
		
		public boolean createAdress(int branchid, Address address) {

			BranchDao branchDao = new BranchDao();
			
			Branch branch  = branchDao.getBranchById(branchid);
			
			if(branch != null) {
				
			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			address.setBranch(branch);
			
			
			entityManager.persist(address);

			entityTransaction.commit();
			System.out.println("address Saved");
			return true;
			}
			else {
				return false;
			}
		}
		
		public List<Address> getAllAddresses(){
			entityManager=getEntityManager();
			Query query=entityManager.createQuery("select s from Address s");
			return query.getResultList();
					
		}
		
		public boolean deleteAddress(int id) {

			entityManager=getEntityManager();
			entityTransaction=entityManager.getTransaction();
			Address u= entityManager.find(Address.class, id);
			if(u!=null) {
				System.out.println("delete method");
				entityTransaction.begin();
				entityManager.remove(u);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		
		public void updateAddress(Address u) {

			entityManager=getEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(u);
			entityTransaction.commit();
			
		}
		
		public Address getAddressById(int id) {
			entityManager=getEntityManager();
			entityTransaction=entityManager.getTransaction();
			return entityManager.find(Address.class, id);
		}
		
	}