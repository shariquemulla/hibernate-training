package com.luv2code.hibernate.enums;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EnumDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent = new Student("John2", "Cena2", "john@luv2code.com", Status.ACTIVE);
			Student tempStudent2 = new Student("Johny", "Doe", "john@luvcode.com", Status.INACTIVE);
			
			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving the student ");
			session.persist(tempStudent);
			session.persist(tempStudent2);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			// clean up code
			session.close();
			factory.close();
		}

	}

}
