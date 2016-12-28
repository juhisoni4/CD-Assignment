package com.frt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frt.model.Project;
import com.frt.service.ProjectService;


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
