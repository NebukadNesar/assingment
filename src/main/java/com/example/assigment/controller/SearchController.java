package com.example.assigment.controller;

import com.example.assigment.joined.CourseByProfessor;
import com.example.assigment.repository.SearchRepository;
import com.example.assigment.utility.ResponseBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

	private SearchRepository searchRepository;

	public SearchController(SearchRepository searchRepository) {
		this.searchRepository = searchRepository;
	}

	@GetMapping
	public List<CourseByProfessor> search() {
		List queryRequelt = searchRepository.findAllCoursesByProfessors();
		return ResponseBuilder.convert(queryRequelt);
	}

}
