package com.example.assigment.controller;

import com.example.assigment.model.Course;
import com.example.assigment.repository.CourseReposity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/course"))
public class CourseController {

	private CourseReposity courseReposity;

	public CourseController(CourseReposity courseReposity) {
		this.courseReposity = courseReposity;
	}

	@PostMapping("/create")
	public void create(@RequestBody Course course) {
		courseReposity.save(course);
	}

	@GetMapping("/read/{id}")
	public Course read(@PathVariable Integer id) {
		Optional<Course> result = courseReposity.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		courseReposity.deleteById(id);
	}
}
