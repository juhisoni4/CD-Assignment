package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.SubProject;
import com.frt.repository.SubProjectRepository;
import com.frt.service.SubProjectService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class SubProjectServiceImpl implements SubProjectService{

	@Autowired
	public SubProjectRepository subProjectRepository;
	
	@Override
	public void saveSubProject(SubProject subProject) {
		
		subProjectRepository.saveSubProject(subProject);
	}

	@Override
	public SubProject getSubProjectById(Long id) {
		
		SubProject subProject = subProjectRepository.getSubProjectById(id);
		return subProject;
	}

	@Override
	public List<SubProject> getAllSubProject() {

		List<SubProject> subProjectList = new ArrayList<>();
		subProjectList = subProjectRepository.getAllSubProject();
		return subProjectList;
	}

}
