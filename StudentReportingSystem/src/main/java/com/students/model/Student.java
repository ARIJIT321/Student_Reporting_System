package com.students.model;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Document(indexName = "student")
public class Student {
	@Id
	private Integer id;
	private Integer Name;
	private List<Marks> marks;

}
