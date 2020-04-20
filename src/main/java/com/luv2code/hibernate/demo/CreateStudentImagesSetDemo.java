package com.luv2code.hibernate.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentImagesSetDemo {


	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
		//create the object
			Student tempStudent = new Student("John","Cena","john@luv2code.com");
//			List<String> theImages = tempStudent.getImages();
//			
//			theImages.add("photo1.jpg");
//			theImages.add("photo2.jpg");
//			theImages.add("photo3.jpg");
//			theImages.add("photo4.jpg");
//			theImages.add("photo4.jpg"); //Duplicate, allowed by List
//			theImages.add("photo5.jpg");
//			theImages.add("photo5.jpg"); //Duplicate
			
			
//			Map<String, String> theImages = tempStudent.getImages();
//			
//			theImages.put("photo1.jpg", "Photo 1");
//			theImages.put("photo2.jpg", "Photo 2");
//			theImages.put("photo3.jpg", "Photo 3");
			
			
//			Set<String> theImages = tempStudent.getImages();
//			
//			theImages.add("photo1.jpg");
//			theImages.add("photo4.jpg");
//			theImages.add("photo3.jpg");
//			theImages.add("photo2.jpg");
//			theImages.add("photo4.jpg"); //Duplicate, filtered at java level by HashSet!!!
//			theImages.add("photo5.jpg");
//			theImages.add("photo5.jpg"); //Duplicate, filtered at java level by HashSet!!!
			
			
			Map<String, String> theImages = tempStudent.getImages();
			
			theImages.put("photo1.jpg", "Photo 1");
			theImages.put("photo2.jpg", "Photo 2");
			theImages.put("photo3.jpg", "Photo 3");
			
		//start a transaction
			session.beginTransaction();
			
		//save the object
			System.out.println("Saving the student and images..");
			session.persist(tempStudent);
			
		//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally {
		//clean up code
			session.close();
			factory.close();
		}
		

	}

}
