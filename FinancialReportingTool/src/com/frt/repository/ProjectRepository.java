package com.frt.repository;

import java.util.List;
import com.frt.model.Project;

public interface ProjectRepository {

	public void saveProject(Project project);

	public Project getProjectById(Long id);

	public List<Project> getAllProject();
}
