package com.example.assigment.repository;

import com.example.assigment.model.SearchQueryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchQueryModel, Integer> {

	@Query(value = "select prof.name as profName, crs.name as courseName FROM PROFESSOR prof " +
			"right join SCHEDULE sc on prof.id = sc.professor_id " +
			"left join COURSE crs on sc.course_id = crs.id ORDER BY prof.name;", nativeQuery = true)
	List<Object[]> findAllCoursesByProfessors();

}