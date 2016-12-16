package com.finance.reporting.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {
	
	@Autowired
	public FrtDao frtDao;
	
	@RequestMapping(value = "/")
	public String welcom() {
		frtDao.add();
		return "index";
	}
	
	
}
