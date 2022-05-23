package com.example.assigment.controller;

import com.example.assigment.model.Professor;
import com.example.assigment.repository.ProfessorRepository;
import com.example.assigment.smallcache.ProfessorCache;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	private ProfessorRepository professorRepository;

	private ProfessorCache professorCache;

	public ProfessorController(ProfessorRepository professorRepository, ProfessorCache professorCache) {
		this.professorRepository = professorRepository;
		this.professorCache = professorCache;
	}

	@PostMapping("/create")
	public void create(@RequestBody Professor professor) {
		Professor professorSaved = professorRepository.save(professor);
		if (professorSaved.equals(professor)) {
			professorCache.add(professorSaved);
		}
	}

	@GetMapping("/read/{id}")
	public Professor read(@PathVariable Integer id) {
		Professor professor = professorCache.find(Professor.find(id));
		if (professor != null) {
			return professor;
		}
		Optional<Professor> result = professorRepository.findById(id);
		if (result.isPresent()) {
			professorCache.add(result.get());
			return result.get();
		}
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		professorCache.delete(Professor.find(id));
		professorRepository.deleteById(id);
	}
}
