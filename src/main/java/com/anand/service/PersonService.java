package com.anand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import java.util.stream.Collectors;

import com.anand.entity.Person;

import java.util.List;
import java.util.ArrayList;

@Service
public class PersonService {

	@Autowired
	PersonService personService;

	public List<Person> searchPerson(String firstName, String lastName) {
		List<Person> allPersons=personService
									.listAllPerson()
									.stream()
									.filter(person-> person.getFirstName().equalsIgnoreCase(firstName)  && person.getLastName().equalsIgnoreCase(lastName))
									.collect(Collectors.toList());
		return allPersons;
		
		
	}
	/**
	 * List all persons
	 * @return
	 */
	@Cacheable("listpersons")
	public List<Person> listAllPerson() {
		
		List<Person> allPersons=new ArrayList<Person>();
		
		allPersons.add(new Person("John","Smith"));
		allPersons.add(new Person("Adam","Smith"));
		allPersons.add(new Person("Gary","Smith"));
		allPersons.add(new Person("Green","Smith"));
		allPersons.add(new Person("Leah","Tehila"));
		allPersons.add(new Person("Leah","Sam"));
		allPersons.add(new Person("Jean","Castle"));
		allPersons.add(new Person("Brook","biss"));
		allPersons.add(new Person("Jack peeas","Jill"));
		allPersons.add(new Person("Jil","Ken"));
		allPersons.add(new Person("John","Smith"));
		return allPersons;
		
		
	}
	 
}
