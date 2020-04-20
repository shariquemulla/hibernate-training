package com.luv2code.hibernate.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent = new Student("John2", "Cena2", "john@luv2code.com");
			Address address = new Address("strddd", "Mumbai", "400001");
			Address billingAddress = new Address("bill", "bill-Mumbai", "bill-400001");
			
			tempStudent.setAddress(address);
			tempStudent.setBillingAddress(billingAddress);

			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving the student ");
			session.persist(tempStudent);

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
