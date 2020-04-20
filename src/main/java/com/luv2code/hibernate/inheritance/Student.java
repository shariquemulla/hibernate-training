package com.luv2code.hibernate.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
//@DiscriminatorValue(value="STUDENT")
public class Student extends User{


	public Student(String firstName, String lastName, String email, String course) {
		super(firstName, lastName, email);
		this.course = course;
	}

	private String course;
		
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
}
