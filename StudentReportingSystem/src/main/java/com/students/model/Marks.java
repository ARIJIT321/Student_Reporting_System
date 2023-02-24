package com.students.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
//import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Data
@Document(indexName = "marks")
@Getter
public class Marks {

	@Id
	private Integer id;
	private Integer studentId;
	private Semester semester;
	private Integer english;
	private Integer maths;
	private Integer science;
}
