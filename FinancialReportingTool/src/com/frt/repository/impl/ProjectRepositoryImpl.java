package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.Project;
import com.frt.repository.ProjectRepository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	@Autowired
	public SessionFactory factory;
	
	@Override
	public Project getProjectById(Long id) {
		
		Project project = (Project) factory.getCurrentSession().get(Project.class, id);
		return project;
	}

	@Override
	public List<Project> getAllProject() {
		
		List<Project> projectList = new ArrayList<>();
		projectList = factory.getCurrentSession().createQuery("from Project").list();
		return projectList;
	}

	@Override
	public void saveProject(Project project) {
		
		factory.getCurrentSession().saveOrUpdate(project);
		
	}

}
