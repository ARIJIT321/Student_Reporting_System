package com.students.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.model.Student;
import com.students.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public List<Student> findAll() {
        Iterable<Student> iterable = studentRepository.findAll();
        List<Student> students = new ArrayList<>();
        iterable.forEach(students::add);
        return students;
    }
}
