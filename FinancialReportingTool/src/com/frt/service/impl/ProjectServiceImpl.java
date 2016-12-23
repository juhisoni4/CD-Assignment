package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.Project;
import com.frt.repository.ProjectRepository;
import com.frt.repository.ProjectResourceRepository;
import com.frt.service.ProjectService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	public ProjectRepository projectRepository;
	
	@Override
	public void saveProject(Project project) {
		
		projectRepository.saveProject(project);
	}

	@Override
	public Project getProjectById(Long id) {
		
		Project project = projectRepository.getProjectById(id);
		return project;
	}

	@Override
	public List<Project> getAllProject() {

		List<Project> projectList = new ArrayList<>();
		projectList = projectRepository.getAllProject();
		return projectList;
	}

}
