package com.example.assigment;

import com.example.assigment.model.Professor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.Assert;

@SpringBootTest
public class TestProfessor {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getRandomProfessor() {
		Professor professor = restTemplate.getForObject("http://localhost:" + port + "/professor/read/" + 1, Professor.class);
		System.out.println("professor = " + professor);
		Assert.isTrue(professor.getName().equals("John Doe"), "professor not correct.");
	}

}
