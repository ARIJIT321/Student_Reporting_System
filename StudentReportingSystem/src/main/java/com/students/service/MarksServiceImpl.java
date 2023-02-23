package com.students.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.model.Marks;
import com.students.repo.MarksRepo;

@Service
public class MarksServiceImpl implements MarksService{
    @Autowired
    private MarksRepo marksRepository;

    public Marks save(Marks marks) {
        return marksRepository.save(marks);
    }

    public List<Marks> findByStudentId(Integer studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    public List<Marks> findAll() {
        Iterable<Marks> iterable = marksRepository.findAll();
        List<Marks> marks = new ArrayList<>();
        iterable.forEach(marks::add);
        return marks;
    }
}
