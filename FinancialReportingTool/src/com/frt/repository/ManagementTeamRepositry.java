package com.frt.repository;

import java.util.List;
import com.frt.model.ManagementTeam;

public interface ManagementTeamRepositry {

	public Double getManagementTeamPersonRevenue(String columnName, String personName);
	
	public void saveManagementTeam(ManagementTeam managementTeam);
	
	public ManagementTeam getManagementTeamById(Long id);
	
	public List<ManagementTeam> getAllManagementTeam();
}
