package onetoonem4.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonem4.dao.AadharCardDao;
import onetoonem4.dao.PersonDao;
import onetoonem4.dto.AadharCard;
import onetoonem4.dto.Person;

public class PersonAadharMain {
public static void main(String[] args) {
	
	
	
//	Person person=new Person();
//	person.setId(2);
//    person.setName("poojitha");
//    person.setAddress("Mysore");
//  
//    PersonDao personDao=new PersonDao();
//    personDao.savePerson(person);
	
	
//	AadharCard aadharCard=new AadharCard();
//	aadharCard.setId(200);
//	aadharCard.setName("Pooji");
//	aadharCard.setAge(21);
//	
//	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.saveAadharCard(200, aadharCard);
	
	
//	
////	FIND
////	PersonDao personDao=new PersonDao();
////	personDao.findPerson(1);
//	
//	
//	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.findAadharCard(100);
//	
//	DELETE
//	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.deleteAadharCard(200);

//	PersonDao personDao=new PersonDao();
//	personDao.deletePerson(1);
	
//	UPDATe
	AadharCard aadharCard=new AadharCard();
	
	aadharCard.setName("Poojitha");
	aadharCard.setAge(21);
	AadharCardDao aadharCardDao=new AadharCardDao();
	aadharCardDao.updateAadharCard(200, aadharCard);
	
	Person person=new Person();
	person.setAddress("Bang");
	person.setName("Pooji");
	
	
//	
	PersonDao personDao=new PersonDao();
	personDao.findPersonByName("Pooji");
	
	
	
	
//	personDao.updatePerson(2, person);
	
	
	
	
}

}
