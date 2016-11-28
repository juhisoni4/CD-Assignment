package com.crud.mvc.spring.hibernate;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value= "showStudent.do")
	public String showStudent(){
		return "student_list";
	}

	@RequestMapping(value= "addJsp.do")
	public String addStudent(){
		return "add_student";
	}

	@RequestMapping(value="addStudent")
	public String saveOrupdate(@ModelAttribute("student") Student student){
		
		studentService.saveOrUpdate(student);
		
		return "student_list";
	}
}
