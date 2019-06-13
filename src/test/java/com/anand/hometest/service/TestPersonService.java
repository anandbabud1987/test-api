package com.anand.hometest.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.anand.service.PersonService;

public class TestPersonService {
	

	
	@Test
	public void testListAllPersons(){
		PersonService personService=mock(PersonService.class);
		assertNotNull(personService.listAllPerson());
	}

}
