package com.example.assigment.utility;

import com.example.assigment.joined.CourseByProfessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseBuilder {

	public static List<CourseByProfessor> convert(List<Object[]> result) {
		Map<String, ArrayList> coursesByProfessor = new HashMap<>();
		if (result == null || result.isEmpty()) {
			return Collections.emptyList();
		}
		for (int i = 0; i < result.size(); i++) {
			Object[] profAndCourse = result.get(i);
			String profName = (String) profAndCourse[0];
			String courseName = (String) profAndCourse[1];
			coursesByProfessor.putIfAbsent(profName, new ArrayList());
			coursesByProfessor.get(profName).add(courseName);
		}

		List<CourseByProfessor> byProfessors = new ArrayList<>();
		coursesByProfessor
				.keySet()
				.stream()
				.sorted()
				.forEach(profName -> byProfessors.add(new CourseByProfessor(profName, coursesByProfessor.get(profName))));
		return byProfessors;
	}

}
