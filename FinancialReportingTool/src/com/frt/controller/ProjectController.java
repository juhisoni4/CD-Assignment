package com.frt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.Project;
import com.frt.service.ProjectService;

@RestController
@RequestMapping(value="/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	public void saveProject(Project project){
		
		projectService.saveProject(project);
	}
	
	public void getProjectById(Long id){
		
		Project project = projectService.getProjectById(id);
				
	}
	
	public void getAllProject(){
		
		List<Project> projectList = projectService.getAllProject();
	}
	

}
