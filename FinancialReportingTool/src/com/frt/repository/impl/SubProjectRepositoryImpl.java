package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.SubProject;
import com.frt.repository.SubProjectRepository;

@Repository
public class SubProjectRepositoryImpl implements SubProjectRepository {

	@Autowired
	public SessionFactory factory;
	
	@Override
	public void saveSubProject(SubProject subProject) {
		
		factory.getCurrentSession().saveOrUpdate(subProject);
	}

	@Override
	public SubProject getSubProjectById(Long id) {

		SubProject subProject = (SubProject) factory.getCurrentSession().get(SubProject.class, id);
		return subProject;
	}

	@Override
	public List<SubProject> getAllSubProject() {

		List<SubProject> subProjectList = new ArrayList<>();
		subProjectList = factory.getCurrentSession().createQuery("from SubProject").list();
		return subProjectList;
	}

}
