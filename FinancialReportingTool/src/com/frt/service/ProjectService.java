package com.frt.service;

import java.util.List;

import com.frt.model.Project;

public interface ProjectService {

	public void saveProject(Project project);

	public Project getProjectById(Long id);

	public List<Project> getAllProject();
}
