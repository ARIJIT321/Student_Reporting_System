package com.students.model;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Document(indexName = "student")
@AllArgsConstructor
@Getter
public class Student {
	@Id
	private String id;
	private String Name;
	private List<Semester> semesters;

	
	
}
