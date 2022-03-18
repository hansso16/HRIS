package com.soses.hris.service;

import java.util.List;

import com.soses.hris.api.EmployeeActivityRequest;
import com.soses.hris.api.EmployeeActivityResponse;
import com.soses.hris.entity.ActivityHistory;

public interface ActivityHistoryService {
	
	boolean saveAll(List<ActivityHistory> activityHistoryList);

	boolean saveActivity(ActivityHistory activityHistory);
	
	EmployeeActivityResponse retrieveEmployeeActivity(EmployeeActivityRequest employeeActivityReq);
}
