package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;
import com.ty.dto.Hospital;


public class BranchDao {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
HospitalDao hospitalDao = new HospitalDao();
	
	private EntityManager getEntityManager() {
		
		 entityManagerFactory=Persistence.createEntityManagerFactory("Hospital");
		return entityManagerFactory.createEntityManager();	
	}
	
	
	public boolean saveBranch(Branch branch,int id) {
		Hospital hospital=hospitalDao.getHospitalById(id);
		if(hospital != null) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		branch.setHospital(hospital);
		entityManager.persist(branch);
		entityTransaction.commit();
		System.out.println("Branch Saved");
		return true;
		} else {
			return false;
		}
		
	}
	
	public List<Branch> getAllBranches(){
		entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Branch s");
		return query.getResultList();
				
	}
	
	public boolean deleteBranch(int id) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		Branch u= entityManager.find(Branch.class, id);
		if(u!=null) {
			System.out.println("delete method");
			entityTransaction.begin();
			entityManager.remove(u);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public void updateBranch(Branch u) {

		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(u);
		entityTransaction.commit();
		
	}
	
	public Branch getBranchById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager.find(Branch.class, id);
	}

	
}