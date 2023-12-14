package onetoonem4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.border.EtchedBorder;

import onetoonem4.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
public void findPerson(int id) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
		System.out.println(dbPerson);
	}else {
		System.out.println("Sorry id is not present");
	}
}

public void deletePerson(int id) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbPerson);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present");
	}
}

public void updatePerson(int id,Person person) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
	    person.setId(id);
	    
	    person.setAadharCard(dbPerson.getAadharCard());
		
	    entityManager.merge(person);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present");
	}	
}

public void findPersonByName(String name) {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("Select p from Person p where p.name=?1");
	query.setParameter(1, name);
	Person person=(Person) query.getSingleResult();
	if(person!=null) {
		System.out.println(person);
	}else {
		System.out.println("Sorry that id is not present");
	}
}







}
