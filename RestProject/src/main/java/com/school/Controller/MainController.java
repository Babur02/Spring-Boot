package com.school.Controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.entities.Student;
import com.school.service.StudentService;

@RestController
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/postStudent")
	public Student createStudent(@RequestBody Student student){
		 return studentService.addStudent(student);
	}
	
	@GetMapping("/getStudent")
	public Iterator<Student> getStudents(){
		 Iterator<Student> st=studentService.getAllStudents();
		 return st;
	}
	
	@GetMapping("/getSingleStudent/{roll}")
	public Student getSingleStudent(@PathVariable int roll){
		 Student st = studentService.getSingleStudent(roll);
		 //System.out.println(l);
		 return st;
	}

	@PutMapping("/update")
	public Student updateSingleStudent(@RequestBody Student student){
		 return studentService.updateStudent(student); 
	}

	@DeleteMapping("/delete/{roll}")
	public void deleteSingleStudent(@PathVariable int roll){
		  studentService.deleteStudent(roll);
	}
}
