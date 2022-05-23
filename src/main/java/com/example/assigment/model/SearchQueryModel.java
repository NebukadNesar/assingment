package com.example.assigment.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class SearchQueryModel {
	@Id
	private int id;
}
