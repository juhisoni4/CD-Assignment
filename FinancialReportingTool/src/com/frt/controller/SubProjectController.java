package com.frt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.SubProject;
import com.frt.service.SubProjectService;

@RestController
@RequestMapping(value="/subProject")
public class SubProjectController {
	
	@Autowired
	SubProjectService subProjectService;
	
	public void saveSubProject(SubProject subProject){
		
		subProjectService.saveSubProject(subProject);
	}
	
	public SubProject getSubProjectById(Long id){
		
		SubProject subProject = subProjectService.getSubProjectById(id);
		return subProject;
	}
	
	public List<SubProject> getAllSubProject(){
		
		List<SubProject> subProjectList = new ArrayList<>();		
		subProjectList = subProjectService.getAllSubProject();
		return subProjectList;
	}

}
