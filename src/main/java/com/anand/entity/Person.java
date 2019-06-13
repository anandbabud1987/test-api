package com.anand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_EMPTY)
@Table(name="person")
@NamedQueries(
		@NamedQuery
		(name="Person.FindAll", query="SELECT a FROM Person a") 		
		)
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="first_name",length=100)
	private String firstName;
	
	@Column(name="last_name",length=100)
	private String lastName;
	public Person(String firstname, String lastname) {
		this.firstName=firstname;
		this.lastName=lastname;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
