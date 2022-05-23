package com.example.assigment.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COURSE")
public class Course extends SearchQueryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEPARTMENT_ID")
	private int departmentId;

	@Column(name = "CREDITS")
	private int credits;

	public Course() {
	}

	public Course(int id, String name, int departmentId, int credits) {
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
		this.credits = credits;
	}
}
