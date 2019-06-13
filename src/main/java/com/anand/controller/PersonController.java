package com.anand.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anand.service.PersonService;



@RequestMapping(value="/test")
@RestController
public class PersonController {
	Logger logger=LoggerFactory.getLogger(PersonController.class);
	@Autowired
	PersonService personService;
	
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> searchPerson(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName
			) {
		logger.info("Started searchPerson");
		try {
			return new ResponseEntity<Object>(personService.searchPerson(firstName, lastName), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Something went wrong in searchPerson:",e);
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);


		}

	}
	
	@RequestMapping(value = "/persons/all", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> listAllPersons(
			) {
		logger.info("Started listAllPersons");
		try {
			return new ResponseEntity<Object>(personService.listAllPerson(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Something went wrong in listAllPersons:",e);
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);


		}

	}
}
