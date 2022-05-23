package com.example.assigment.controller;

import com.example.assigment.model.Department;
import com.example.assigment.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private DepartmentRepository departmentRepository;

	public DepartmentController(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@PostMapping("/create")
	public void create(@RequestBody Department department) {
		departmentRepository.save(department);
	}

	@GetMapping("/read/{id}")
	public Department read(@PathVariable Integer id) {
		Optional<Department> result = departmentRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		departmentRepository.deleteById(id);
	}
}
