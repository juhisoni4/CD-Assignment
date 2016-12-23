package com.frt.repository;

import java.util.List;
import com.frt.model.SubProject;

public interface SubProjectRepository {

	public void saveSubProject(SubProject subProject);

	public SubProject getSubProjectById(Long id);

	public List<SubProject> getAllSubProject();
}
