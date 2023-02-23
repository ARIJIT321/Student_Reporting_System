package com.students.model;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Document(indexName = "student")
public class Student {
	@Id
	private Integer id;
	private Integer Name;
	@OneToMany
	private List<Marks> marks;

}
