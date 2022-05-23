package com.example.assigment.smallcache;

import com.example.assigment.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorCache implements Cache<Professor> {

	private static BaseCach professorCache = BaseCach.createBaseCache();

	@Override
	public Professor add(Professor professor) {
		return (Professor) professorCache.add(professor.getId(), professor);
	}

	@Override
	public Professor find(Professor professor) {
		return (Professor) professorCache.find(professor.getId());
	}

	@Override
	public Professor delete(Professor professor) {
		return (Professor) professorCache.delete(professor.getId());
	}
}
