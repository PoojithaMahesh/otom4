package onetoonem4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonem4.dto.AadharCard;
import onetoonem4.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	
	public void saveAadharCard(int personId,AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, personId);
		
		if(dbPerson!=null) {
//			that person exist i can give a adharCard
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
		
			entityManager.persist(aadharCard);
			dbPerson.setAadharCard(aadharCard);
			entityTransaction.commit();
		}else {
//			that person doesnotexist
			System.out.println("sorry person id not exist");
		}
	}
	
	public void findAadharCard(int id) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			System.out.println(dbAadharCard);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void deleteAadharCard(int id) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbAadharCard);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry that id is not present");
		}
	}
	
	public void updateAadharCard(int id,AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			aadharCard.setId(id);
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry that id is not present so i cant update the data");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
