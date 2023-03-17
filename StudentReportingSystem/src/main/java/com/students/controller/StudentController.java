package com.students.controller;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.students.model.Semester;
import com.students.model.Student;
import com.students.repo.StudentRepo;
import com.students.service.StudentService;

@Controller
public class StudentController {
    
	   @Autowired
	   private StudentService service;

	    @Autowired
	    private StudentRepo repository;


	    
	    @RequestMapping("/home")
	    public String find(){
	    	for(Student student : repository.findAll()){
	    		System.out.println(student);
	    	}
	        return "home";
	        
	    }
	    
	    @GetMapping("/addStudent")
	    public ModelAndView saveStudent() throws IOException {
	    	ModelAndView model = new ModelAndView("addStudent");
	    	model.addObject("message","this.message");
	        return model;
	    }
	    
	    @PostMapping("/addStudent")     
		public String saveStudent(@RequestParam Integer studentId, @RequestParam String studentName,
				@RequestParam Integer mathematics, @RequestParam Integer science, @RequestParam Integer english,
				@RequestParam Integer semester) {
	    	Semester semester2 = new Semester(semester,english,mathematics,science);
	    	List<Semester> list = new ArrayList<>();
	    	list.add(semester2);
			Student student = new Student(Integer.toString(studentId),studentName,list);
			repository.save(student);
			return "home";
	    }

	    @GetMapping("/getAvgPercBySem")
		public String getPercentageView() {
			return "getPercentage";
		}

		@PostMapping("/getAvgPercBySem")  
		public String getPercentageView(Model model, @RequestParam Integer semester) {
			String avg = service.averagePercentage(semester);
			model.addAttribute("avg", avg);  
			return "getAvgPercBySem";  
		}


	    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	    public String deleteStudentByID(@RequestParam("SId") String SId)
	    {
	        try {
	            String response = service.deleteStudent(SId);
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.toString());
	            return (e.toString());
	        }

	        return "redirect:/";
	    }

	    @GetMapping("/topTwo")
		public String topView() {
	    	HashMap<String, Double> map = service.top2();
	    	System.out.println(map);
			return "topTwo";
		}

		@PostMapping("/topTwo")   
		public String topView(Model model) {
			HashMap<String, Double> map = service.top2();
			model.addAttribute("top2", map);
			return "topTwo";       
		}



	    





}

