package com.example.springtestapi.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service ya da @Component aynı şeyleer.
@Service //okunabilirk acısından bunu kullan
//servis'in için de repository'i (interface) kullanacağız.
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		
		studentRepository.save(student);
		
		
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		
		if (!exists) {
			throw new IllegalStateException("Studant with id " + studentId + " doen not exists");
		}
		
		studentRepository.deleteById(studentId);
		
	}

	//@Transactional da querey yazmana gerek kalmıyor.
	//service layer da bu işleri yapıyorsun.
	/*
	 * @Transactional public void updateStudent(Long studentId, String name, String
	 * email) {
	 * 
	 * Student student = studentRepository.findById(studentId) .orElseThrow(() ->
	 * new IllegalStateException("student with id " + studentId +
	 * " does not exists"))) }
	 */
	
}
