package com.example.assigment.repository;

import com.example.assigment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseReposity extends JpaRepository<Course, Integer> {
}
