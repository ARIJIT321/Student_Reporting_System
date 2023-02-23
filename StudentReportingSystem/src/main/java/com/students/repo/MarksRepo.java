package com.students.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.students.model.Marks;

public interface MarksRepo extends ElasticsearchRepository<Marks, Integer>{
	List<Marks> findByStudentId(Integer studentId);

}
