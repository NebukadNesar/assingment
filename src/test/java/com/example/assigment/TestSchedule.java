package com.example.assigment;

import com.example.assigment.model.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootTest
public class TestSchedule {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAllSchedules() {
		List<Schedule> schedules = restTemplate.getForObject("http://localhost:" + port + "/schedule/read/", List.class);
		Assert.isTrue(!schedules.isEmpty(), "no schedules found in database.");
		Assert.isTrue(schedules.size() == 13, "schedules size does not match");
	}

	@Test
	public void testAddAndGetSchedules() {
		Schedule schedule = new Schedule(4, 5, 6, 1998);
		restTemplate.postForEntity("http://localhost:" + port + "/schedule/create", schedule, Void.class);
		Schedule[] schedules = restTemplate.getForObject("http://localhost:" + port + "/schedule/read/", Schedule[].class);

		Assert.isTrue(schedules.length > 0, "no schedules found in database.");
		Assert.isTrue(schedules.length == 14, "schedules size does not match after adding new one.");

		AtomicBoolean found = new AtomicBoolean(false);
		for (Schedule s : schedules) {
			if (s.equals(schedule)) {
				found.set(true);
				break;
			}
		}

		Assert.isTrue(found.get(), "newly added schedules is not found.");
	}

}
