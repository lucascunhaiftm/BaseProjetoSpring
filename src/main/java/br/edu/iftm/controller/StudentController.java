package br.edu.iftm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.model.Student;
import br.edu.iftm.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public Long addStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student.getStudentId();
	}
	
	@GetMapping("/viewAll")
	public Iterable<Student> viewAllStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/view/{id}")
	public Student viewStudentById(@PathVariable ("id") Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return student.get();
		}
		
		return null;
		//throw new InvalidTransationReferenceException("Invalid transaction reference provided");
	}
	

}
