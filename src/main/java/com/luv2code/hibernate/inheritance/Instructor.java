package com.luv2code.hibernate.inheritance;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="INSTRUCTOR")
public class Instructor extends User {

	public Instructor(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
	}
	
	private Double salary;
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
