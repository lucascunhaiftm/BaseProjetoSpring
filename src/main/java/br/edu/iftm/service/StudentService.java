package br.edu.iftm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.model.Student;
import br.edu.iftm.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
}
