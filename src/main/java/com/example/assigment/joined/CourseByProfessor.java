package com.example.assigment.joined;

import lombok.Data;

import java.util.List;

@Data
public class CourseByProfessor {
	private String name;
	private List<String> courses;

	public CourseByProfessor() {
	}

	public CourseByProfessor(String name, List<String> courses) {
		this.name = name;
		this.courses = courses;
	}
}
