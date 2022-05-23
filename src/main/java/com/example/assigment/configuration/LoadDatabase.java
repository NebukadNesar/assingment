package com.example.assigment.configuration;

import com.example.assigment.model.Course;
import com.example.assigment.model.Department;
import com.example.assigment.model.Professor;
import com.example.assigment.model.Schedule;
import com.example.assigment.repository.CourseReposity;
import com.example.assigment.repository.DepartmentRepository;
import com.example.assigment.repository.ProfessorRepository;
import com.example.assigment.repository.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase implements CommandLineRunner {

	DepartmentRepository departmentRepository;
	CourseReposity courseReposity;
	ScheduleRepository scheduleRepository;
	ProfessorRepository professorRepository;

	public LoadDatabase(DepartmentRepository departmentRepository, CourseReposity courseReposity, ScheduleRepository scheduleRepository,
			ProfessorRepository professorRepository) {
		this.departmentRepository = departmentRepository;
		this.courseReposity = courseReposity;
		this.scheduleRepository = scheduleRepository;
		this.professorRepository = professorRepository;
	}

	void initDepartment() {
		List<Department> departmentList = new ArrayList<Department>() {
			{
				add(new Department(1, "Physical Sciences"));
				add(new Department(2, "Clinical Medicine"));
				add(new Department(3, "Biological Sciences"));
				add(new Department(4, "Arts and Humanities"));
				add(new Department(5, "Technology"));
				add(new Department(6, "Humanities & Social Sciences"));
			}
		};
		departmentRepository.saveAll(departmentList);
	}

	void initCourse() {
		List<Course> courseList = new ArrayList<Course>() {
			{
				add(new Course(1, "Pure Mathematics and Mathematical Statistics", 1, 3));
				add(new Course(2, "Earth Science", 1, 5));
				add(new Course(3, "Earth Science", 1, 7));
				add(new Course(4, "Astronomy", 1, 6));
				add(new Course(5, "Physics", 1, 8));
				add(new Course(6, "Geography", 1, 7));
				add(new Course(7, "Materials Science and Metallurgy", 1, 5));
				add(new Course(8, "Chemistry", 1, 1));
				add(new Course(9, "Clinical Biochemistry", 2, 3));
				add(new Course(10, "Clinical Neuroscience", 2, 5));
			}
		};
		courseReposity.saveAll(courseList);
	}

	void initProfessor() {
		List<Professor> professorList = new ArrayList<Professor>() {
			{
				add(new Professor(1, "John Doe", 5));
				add(new Professor(2, "Frida Mcintosh", 2));
				add(new Professor(3, "Grace Avery", 1));
				add(new Professor(4, "Ada Osborne", 3));
				add(new Professor(5, "Rowan Graves", 1));
				add(new Professor(6, "Selena Owen", 5));
				add(new Professor(7, "Sarahi Barry", 2));
				add(new Professor(8, "Camden Lin", 1));
				add(new Professor(9, "Daniel Hicks", 5));
				add(new Professor(10, "Timothy Hickman", 4));
			}
		};
		professorRepository.saveAll(professorList);
	}

	void initSchedule() {
		List<Schedule> scheduleList = new ArrayList<Schedule>() {
			{
				add(new Schedule(5, 3, 6, 2012));
				add(new Schedule(7, 3, 1, 2013));
				add(new Schedule(5, 7, 6, 2010));
				add(new Schedule(2, 10, 2, 2004));
				add(new Schedule(5, 1, 1, 2011));
				add(new Schedule(2, 9, 4, 2005));
				add(new Schedule(7, 10, 6, 2009));
				add(new Schedule(5, 6, 4, 2007));
				add(new Schedule(7, 9, 1, 2014));
				add(new Schedule(9, 9, 5, 2011));
				add(new Schedule(9, 9, 5, 2010));
				add(new Schedule(9, 9, 5, 2019));
				add(new Schedule(9, 9, 5, 2018));
			}
		};
		scheduleRepository.saveAll(scheduleList);
	}

	@Override
	public void run(String... args) {
		initProfessor();
		initDepartment();
		initCourse();
		initSchedule();
	}
}
