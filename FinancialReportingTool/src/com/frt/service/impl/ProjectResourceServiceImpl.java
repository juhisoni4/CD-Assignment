package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.ProjectResource;
import com.frt.repository.ProjectResourceRepository;
import com.frt.service.ProjectResourceService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ProjectResourceServiceImpl implements ProjectResourceService {

	@Autowired
	public ProjectResourceRepository projectResourceRepository;
	
	@Override
	public void saveProjectResource(ProjectResource projectResource) {
		
		projectResourceRepository.saveProjectResource(projectResource);
	}

	@Override
	public ProjectResource getProjectResourceById(Long id) {
		
		ProjectResource projectResource = projectResourceRepository.getProjectResourceById(id);
		return projectResource;
	}

	@Override
	public List<ProjectResource> getAllProjectResource() {

		List<ProjectResource> projectResourceList = new ArrayList<>();
		projectResourceList = projectResourceRepository.getAllProjectResource();
		return projectResourceList;
	}

}
