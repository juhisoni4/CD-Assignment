package com.frt.service;

import java.util.List;

import com.frt.model.ProjectResource;

public interface ProjectResourceService {

	public void saveProjectResource(ProjectResource projectResource);

	public ProjectResource getProjectResourceById(Long id);

	public List<ProjectResource> getAllProjectResource();
}
