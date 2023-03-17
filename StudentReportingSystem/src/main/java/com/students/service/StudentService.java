package com.students.service;

import java.util.HashMap;
import java.util.List;

import com.students.model.Student;

public interface StudentService {
	
	public Student getStudent(String studentId);
	
	public List<Student> getAllStudents();
	
	public String averagePercentage(int sem);
	
	public String deleteStudent(String id);
	
	 public HashMap<String, Double> top2();
}
