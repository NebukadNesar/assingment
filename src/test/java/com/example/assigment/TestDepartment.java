package com.example.assigment;

import com.example.assigment.model.Department;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.Assert;

@SpringBootTest
public class TestDepartment {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(3)
	public void testGetRandomDepartment() {
		Department department = restTemplate.getForObject("http://localhost:" + port + "/department/read/" + 4, Department.class);
		System.out.println("department = " + department);
		Assert.isTrue(department.getName().equals("Arts and Humanities"), "correct department not found.");
	}

	@Test
	@Order(2)
	public void testAddDepartment() {
		Department department = new Department(7, "Astronomi");
		restTemplate.postForEntity("http://localhost:" + port + "/department/create", department, Void.class);
		Department departmentAdded = restTemplate.getForObject("http://localhost:" + port + "/department/read/" + 7, Department.class);
		Assert.isTrue(department.equals(departmentAdded), "correct department not found.");
	}

	@Test
	@Order(1)
	public void testDeleteDepartment() {
		restTemplate.delete("http://localhost:" + port + "/department/delete/2");
		Department department = restTemplate.getForObject("http://localhost:" + port + "/department/read/2", Department.class);
		Assert.isTrue(department == null, "department could not be deleted.");
	}
}
