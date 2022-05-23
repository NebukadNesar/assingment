package com.example.assigment;

import com.example.assigment.model.Course;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.Assert;

@SpringBootTest
public class TestCourse {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	public void testAddNewCourse() {
		Course course = new Course(11, "Computer Science", 5, 3);
		restTemplate.postForEntity("http://localhost:" + port + "/course/create", course, Void.class);
		Course courseEdited = restTemplate.getForObject("http://localhost:" + port + "/course/read/" + 11, Course.class);
		Assert.isTrue(courseEdited.getName().equals(course.getName()), "course could not be edited correctly " + course.toString());
	}

	@Test
	@Order(2)
	public void testGetRandomCourse() {
		Course course = restTemplate.getForObject("http://localhost:" + port + "/course/read/" + 1, Course.class);
		Assert.isTrue(course.getName().equals("Pure Mathematics and Mathematical Statistics"), "course not correct.");
	}

}
