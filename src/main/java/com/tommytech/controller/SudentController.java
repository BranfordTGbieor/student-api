package com.tommytech.controller;


import com.tommytech.domain.Student;
import com.tommytech.exception.StudentNotFoundException;
import com.tommytech.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("students")
public class SudentController {
	
	@Autowired
	private StudentRepository repository;

	@GetMapping
	public Iterable<Student> getStudents() {
		return repository.findAll();
	}	

	@GetMapping("{id}")
	public Student getStudent(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(StudentNotFoundException::new);
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@PutMapping("{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student studentToUpdate = repository.findById(id).orElseThrow(StudentNotFoundException::new);

		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setYear(student.getYear());

		return repository.save(studentToUpdate);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		repository.findById(id).orElseThrow(StudentNotFoundException::new);
		repository.deleteById(id);
	}

}
