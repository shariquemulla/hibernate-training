package com.luv2code.hibernate.demo.entity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.SortComparator;

@Entity
@Table(name="student")
public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
		
//	@ElementCollection
//	@CollectionTable(name="image", //defaults to student_images
//					joinColumns = @JoinColumn(name="student_id"))
//	@OrderColumn
//	@Column(name="file_name") //defaults to images
//	private List<String> images = new ArrayList<String>();
	
	
//	@ElementCollection
//	@CollectionTable(name="image", //defaults to student_images
//					joinColumns = @JoinColumn(name="student_id"))
//	@MapKeyColumn(name="file_name")
//	@Column(name="image_name") 
//	private Map<String, String> images = new HashMap<String, String>();
	
	
//	@ElementCollection
//	@CollectionTable(name="image", //defaults to student_images
//					joinColumns = @JoinColumn(name="student_id"))
//	@OrderBy(clause="file_name DESC")
//	@Column(name="file_name") //defaults to images
//	private Set<String> images = new LinkedHashSet<String>();
	
	
	@ElementCollection
	@CollectionTable(name="image", //defaults to student_images
					joinColumns = @JoinColumn(name="student_id"))
	@MapKeyColumn(name="file_name")
//	@javax.persistence.OrderBy
	@SortComparator(ReverseComparator.class)
	@Column(name="image_name") 
	private SortedMap<String, String> images = new TreeMap<String, String>();
	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public static class ReverseComparator implements Comparator<String>{

		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public SortedMap<String, String> getImages() {
		return images;
	}

	public void setImages(SortedMap<String, String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
