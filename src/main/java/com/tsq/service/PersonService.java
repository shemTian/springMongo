package com.tsq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsq.dao.PersonDao;
import com.tsq.model.Person;

@Service
public class PersonService {
	@Autowired
	PersonDao personDao;
	
	public Person createPerson(Person person){
		personDao.save(person);
		return person;
	}
	public List<Person> getPersonPage(int startIndex,int pageSize){
		return personDao.queryPage(startIndex, pageSize);
	}
	public void modifyPerson(Person person){
		personDao.updatePerson(person);
	}
}
