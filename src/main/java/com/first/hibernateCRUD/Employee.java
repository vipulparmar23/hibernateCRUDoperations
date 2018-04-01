package com.first.hibernateCRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {	
		return "Employee Details ==>> ID :"+this.id+" || FIRST NAME: "+this.firstName+" || LAST NAME:"+this.lastName;
	}
	
}
