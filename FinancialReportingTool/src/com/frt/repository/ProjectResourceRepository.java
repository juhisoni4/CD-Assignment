package com.frt.repository;

import java.util.List;

import com.frt.model.ProjectResource;

public interface ProjectResourceRepository {

	public void saveProjectResource(ProjectResource projectResource);

	public ProjectResource getProjectResourceById(Long id);

	public List<ProjectResource> getAllProjectResource();
}
