package br.edu.iftm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
