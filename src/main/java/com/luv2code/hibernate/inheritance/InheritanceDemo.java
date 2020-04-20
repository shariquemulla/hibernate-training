package com.luv2code.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
//				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent = new Student("John2", "Cena2", "john@luv2code.com", "Hibernate");
			Instructor tempInstructor = new Instructor("Johny", "Doe", "john@luvcode.com", 22044.00);
			
			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving the student ");
			session.persist(tempStudent);
			session.persist(tempInstructor);

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
