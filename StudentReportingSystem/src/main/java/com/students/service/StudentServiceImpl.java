package com.students.service;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.model.Semester;
import com.students.model.Student;
import com.students.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private StudentRepo studentRepository;

    private final String indexName = "student-index";


    @Override
    public Student getStudent(String studentId) {

        try {
            Optional<Student> students = studentRepository.findById(studentId);

            if (students.isEmpty()) {
                throw new Exception("getStudent() failed!");
            }

            Student student = students.get();
            return student;

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            Iterable<Student> students = studentRepository.findAll();
            List<Student> studentList = new ArrayList<>();
            for (Student s : students) {
                studentList.add(s);
            }
            return studentList;
        } catch (Exception e) {
            System.out.println("erro : " + e.toString());
        }
        return new ArrayList<Student>();
    }

    @Override
    public String deleteStudent(String id){
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            return  (e.toString());
        }

        return "Successfully deleted student with Id : " + id;

    }


    @Override
    public String averagePercentage(int sem)
    {
        Double average = 0.0;

        try {
            List<Double> percentageList = new ArrayList<>();
            Iterable<Student> studentList = studentRepository.findAll();
            for(Student s : studentList)
            {
                Semester semester = s.getSemesters().get(sem-1);
                Double sum = Double.valueOf((semester.getEnglish() + semester.getMaths() + semester.getScience()));
                Double percentage = sum/3;
                percentageList.add(percentage);
            }

            for(Double d : percentageList)
            {
                average += d;
            }

            average = average/percentageList.size();
            System.out.println("average : " + average);

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        DecimalFormat df = new DecimalFormat("####0.00");

        return df.format(average);
    }



    @Override
    public HashMap<String, Double> top2(){

        HashMap<String, Double> map = new HashMap<String, Double>();

        try {
            Iterable<Student> studentList = studentRepository.findAll();
            for(Student s : studentList)
            {
                Semester semester1 = s.getSemesters().get(0);
                Semester semester2 = s.getSemesters().get(1);
                Double sum = Double.valueOf((semester1.getEnglish() + semester1.getMaths() + semester1.getScience()+
                        semester2.getEnglish() + semester2.getMaths() + semester2.getScience()));
                Double max = sum/2;
                map.put(s.getId(), max);
            }


        }catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return map;
    }
	
}
