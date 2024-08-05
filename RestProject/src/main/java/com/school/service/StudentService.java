package com.school.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.Repository.StudentRepository;
import com.school.entities.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		Student st = studentRepository.save(student);
		return st;
	}
	
	public Iterator<Student> getAllStudents(){
		Iterable iter=studentRepository.findAll();
		Iterator<Student> itr=iter.iterator();
		return itr;
	}
	
	public Student getSingleStudent(int roll){
		Optional<Student> opt=studentRepository.findById(roll);
		Student st = opt.get();
		return st;
	}
	
	public Student updateStudent(Student student) {	
		return studentRepository.save(student);
	}
	
//	public void deleteStudent(int roll){
//		Optional<Student> opt= studentRepository.findById(roll);
//		Student st = opt.get();
//		studentRepository.delete(st);
//	}
	
	public void deleteStudent(int roll) {
	    Optional<Student> opt = studentRepository.findById(roll);
	    if (opt.isPresent()) {
	        Student st = opt.get();
	        studentRepository.delete(st);
	    } else {
	        System.out.println("\nSomthing Went Wrong...\n");
	    }
	}

}
