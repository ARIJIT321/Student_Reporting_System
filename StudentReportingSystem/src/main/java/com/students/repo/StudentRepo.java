package com.students.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.students.model.Student;

public interface StudentRepo extends ElasticsearchRepository<Student,String>{

}
