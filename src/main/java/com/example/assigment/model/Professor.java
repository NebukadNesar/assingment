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
@Table(name = "PROFESSOR")
public class Professor extends SearchQueryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEPARTMENT_ID")
	private int departmentId;

	public Professor() {
	}

	public Professor(int id, String name, int departmentId) {
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
	}

	public static Professor find(Integer id) {
		return new Professor(id, "", -1);
	}

}
