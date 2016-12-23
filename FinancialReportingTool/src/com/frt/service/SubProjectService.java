package com.frt.service;

import java.util.List;

import com.frt.model.SubProject;

public interface SubProjectService {

	public void saveSubProject(SubProject subProject);

	public SubProject getSubProjectById(Long id);

	public List<SubProject> getAllSubProject();
}
