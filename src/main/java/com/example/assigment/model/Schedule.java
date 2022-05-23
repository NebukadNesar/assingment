package com.example.assigment.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "SCHEDULE")
@IdClass(Schedule.class)
public class Schedule implements Serializable {

	@Id
	@Column(name = "PROFESSOR_ID")
	private int professorId;

	@Id
	@Column(name = "COURSE_ID")
	private int courseId;

	@Id
	@Column(name = "SEMESTER")
	private int semester;

	@Id
	@Column(name = "YEAR")
	private int year;

	public Schedule() {
	}

	public Schedule(int professorId, int courseId, int semester, int year) {
		this.professorId = professorId;
		this.courseId = courseId;
		this.semester = semester;
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Schedule schedule = (Schedule) o;
		return professorId == schedule.professorId && courseId == schedule.courseId && semester == schedule.semester && year == schedule.year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(professorId, courseId, semester, year);
	}
}
