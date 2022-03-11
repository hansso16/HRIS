package com.soses.hris.service;

import java.util.List;

import com.soses.hris.dto.ActivityHistoryTO;
import com.soses.hris.entity.ActivityHistory;

public interface ActivityHistoryService {
	
	boolean saveAll(List<ActivityHistory> activityHistoryList);

	boolean saveActivity(ActivityHistory activityHistory);
	
	List<ActivityHistoryTO> retrieveEmployeeActivity(String employeeId);
}
