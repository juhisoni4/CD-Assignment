package com.crud.mvc.spring.hibernate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentLogginDao studentLogginDao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;

	// @RequestMapping(value= "showStudent.do")
	// public String showStudent(){
	// return "student_list";
	// }

	@RequestMapping(value = "addJsp")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentLoggin", new StudentLoggin());
		return "add_student";
	}
	
	@RequestMapping(value = "/")
	public String signUpStudent() {
		return "sign-up";
	}
	
	@RequestMapping(value="loggin")
	public String saveOrEdit(@ModelAttribute("studentLoggin")StudentLoggin studentLoggin){
		studentLogginDao.saveOrUpdate(studentLoggin);
		return "redirect:showStudent";
	}
	

	@RequestMapping(value = "addStudent")
	public String saveOrupdate(@ModelAttribute("student") Student student) {
		studentRepository.saveOrUpdate(student);
		return "redirect:showStudent";
	}
	
//	@RequestMapping(value = "addStudent.do")
//	public String saveOrupdate(@ModelAttribute("student") Student student) {
//		
//		if(student.getId() == null){
//			studentRepository.save(student);
//		}else{
//			studentRepository.update(student);
//		}
//		return "redirect:showStudent.do";
//	}
	

	@RequestMapping(value = "showStudent")
	public String getAllStudents(Model model) {		
		model.addAttribute("STUDENT_LIST", studentRepository.listStudent());
		return "student_list";
	}

	@RequestMapping(value = "deleteStudent")
	public String deleteStudent(@RequestParam("studentId") String studentId,
			Model model) {
		studentRepository.deleteStudent(studentId);
		return "redirect:showStudent";
	}

	@RequestMapping(value = "loadStudent")
	public String loadStudent(@RequestParam("studentId") String studentId,
			Model model) {
		Student student = studentRepository.getStudent(studentId);
		model.addAttribute("student", student);
		return "add_student";
	}
	
	 @RequestMapping(value="logout")
     public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (auth != null){    
           new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "sign-up";
     }
}
