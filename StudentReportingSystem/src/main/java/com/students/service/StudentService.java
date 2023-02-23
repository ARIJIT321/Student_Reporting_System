package com.students.service;

import java.util.List;

import com.students.model.Student;

public interface StudentService {

	public Student save(Student student);
	
	public Student findById(Integer id);
	
	public List<Student> findAll();
}
