package com.students.model;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(indexName = "marks")
public class Marks {

	@Id
	private Integer id;
	private Integer studentId;
	private Semester semester;
	private Integer english;
	private Integer maths;
	private Integer science;
}
