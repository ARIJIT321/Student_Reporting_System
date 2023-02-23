package com.students.service;

import java.util.List;

import com.students.model.Marks;

public interface MarksService {

	public Marks save(Marks marks);
	
	public List<Marks> findByStudentId(Integer studentId);
	
	public List<Marks> findAll();
	
}
