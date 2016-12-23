package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.ManagementTeam;
import com.frt.repository.ManagementTeamRepositry;
import com.frt.service.ManagementTeamService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ManagementTeamServiceImpl implements ManagementTeamService {

	@Autowired
	public ManagementTeamRepositry managementTeamRepositry;

	public Double getManagementTeamPersonRevenue(String columnName,
			String personName) {
		Double financeData = managementTeamRepositry
				.getManagementTeamPersonRevenue(columnName, personName);
		return financeData;
	}

	public void saveManagementTeam(ManagementTeam managementTeam) {
		
		managementTeamRepositry.saveManagementTeam(managementTeam);
		
	}

	@Override
	public ManagementTeam getManagementTeamById(Long id) {
		
		ManagementTeam managementTeam = managementTeamRepositry.getManagementTeamById(id);
		return managementTeam;
	}

	@Override
	public List<ManagementTeam> getAllManagementTeam() {
		
		List<ManagementTeam> managementTeamList = new ArrayList<>();
		managementTeamList = managementTeamRepositry.getAllManagementTeam();
		return managementTeamList;
	}

	

}
