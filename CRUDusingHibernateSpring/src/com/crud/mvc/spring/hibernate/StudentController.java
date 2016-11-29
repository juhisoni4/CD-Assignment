package com.crud.mvc.spring.hibernate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@SessionAttributes("student")
public class StudentController {	
	
	@Autowired
	private StudentRepository studentRepository;
	
//	@RequestMapping(value= "showStudent.do")
//	public String showStudent(){
//		return "student_list";
//	}

	@RequestMapping(value= "addJsp.do")
	public String addStudent(){
		return "add_student";
	}

	@RequestMapping(value="addStudent.do")
	public String saveOrupdate(@ModelAttribute("student") Student student,Model model){
		studentRepository.saveOrUpdate(student);
		model.addAttribute("student",student);
		return "redirect:showStudent.do";
	}
	
	@RequestMapping(value="showStudent.do")
	public String getAllStudents(Model model){
		model.addAttribute("STUDENT_LIST", studentRepository.listStudent());
		return "student_list";
	}
	
	@RequestMapping(value="/deleteStudent.do")
	public String deleteStudent(@RequestParam("studentId") String studentId,Model model) {
		studentRepository.deleteStudent(studentId);		
		return  "redirect:showStudent.do";
	}
	
	@RequestMapping(value="/loadStudent.do")
	public String loadStudent(@RequestParam("studentId") String studentId,Model model){
		Student student = studentRepository.getStudent(studentId);
		model.addAttribute("STUDENT", student);		
		return "add_student";
	}
}
