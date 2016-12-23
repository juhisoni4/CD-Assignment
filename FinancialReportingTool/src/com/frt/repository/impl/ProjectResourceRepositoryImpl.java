package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.ProjectResource;
import com.frt.repository.ProjectResourceRepository;

@Repository
public class ProjectResourceRepositoryImpl implements ProjectResourceRepository {

	@Autowired
	public SessionFactory factory;
	
	@Override
	public void saveProjectResource(ProjectResource projectResource) {
		
		factory.getCurrentSession().saveOrUpdate(projectResource);

	}

	@Override
	public ProjectResource getProjectResourceById(Long id) {
		
		ProjectResource projectResource = (ProjectResource) factory.getCurrentSession().get(ProjectResource.class, id);
		return projectResource;
	}

	@Override
	public List<ProjectResource> getAllProjectResource() {

		List<ProjectResource> projectResourceList = new ArrayList<>();
		projectResourceList = (List<ProjectResource>) factory.getCurrentSession().createQuery("from ProjectResource");
		return projectResourceList;
	}

}
