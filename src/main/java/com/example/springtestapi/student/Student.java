package com.example.springtestapi.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity //hibernate icin
@Table //veritabanında tabloyu gösterir.
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_sequence", 
			sequenceName = "student_sequence", 
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;//date of birth
	
	@Transient
	private Integer age;
	//bu sütuna artık tabloda yer olmayacak.
	
	public Student() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param dob
	 */
	public Student(Long id, 
			String name, 
			String email, 
			LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	/**
	 * @param name
	 * @param email
	 * @param dob
	 */
	public Student(String name, 
			String email, 
			LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", dob=" + dob + "]";
	}
	
	

}
