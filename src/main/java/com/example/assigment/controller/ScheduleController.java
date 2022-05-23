package com.example.assigment.controller;

import com.example.assigment.model.Schedule;
import com.example.assigment.repository.ScheduleRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	private ScheduleRepository scheduleRepository;

	public ScheduleController(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	@PostMapping("/create")
	public void create(@RequestBody Schedule schedule) {
		scheduleRepository.save(schedule);
	}

	@GetMapping("/read")
	public List<Schedule> read() {
		System.out.println(" search request .. ");
		return scheduleRepository.findAll();
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam Integer professorId, @RequestParam Integer courseId, @RequestParam Integer semester, @RequestParam Integer year) {
		Schedule schedule = new Schedule(professorId, courseId, semester, year);
		System.out.println("schedule = " + schedule);
		scheduleRepository.delete(schedule);
	}
}
