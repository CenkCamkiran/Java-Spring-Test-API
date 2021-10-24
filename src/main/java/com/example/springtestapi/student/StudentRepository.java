package com.example.springtestapi.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Repo'nun calistigi type of object
//istediğimiz type id, id for our student 
//Student class'da private Long id; yazıyor bundan dolayı id long.
//this interface is responsible for data access
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	//this here will transform to an sql
	//Select * from student where email = ?
	//aslında bu query i comment e alabilirsin ama
	//kodun okunabilirliği açısından bu ifadeyi
	//koymak daha iyi olur
	//From dan sornaki Student aslında bizim Student sınıfıdır.
	@Query("Select s From Student s Where s.email = ?1")
	Optional<Student> findStudentByEmail(String email);

}
