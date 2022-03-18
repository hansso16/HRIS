package com.soses.hris.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soses.hris.api.EmployeeActivityRequest;
import com.soses.hris.api.EmployeeActivityResponse;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.ActivityHistory;
import com.soses.hris.repository.ActivityHistoryRepository;
import com.soses.hris.service.ActivityHistoryService;

@Service("ActivityHistoryServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ActivityHistoryServiceImpl implements ActivityHistoryService {

	private ActivityHistoryRepository activityHistoryRepo;

	@Autowired
	public ActivityHistoryServiceImpl(ActivityHistoryRepository activityHistoryRepo) {
		super();
		this.activityHistoryRepo = activityHistoryRepo;
	}

	@Override
	public boolean saveActivity(ActivityHistory activityHistory) {
		if (activityHistory != null) {
			activityHistoryRepo.save(activityHistory);
			return true;
		}
		return false;
	}

	@Override
	public EmployeeActivityResponse retrieveEmployeeActivity(EmployeeActivityRequest request) {
		
		EmployeeActivityResponse response = new EmployeeActivityResponse();
		Page<ActivityHistory> activityPage = null;
		String employeeId = request.getEmployeeId();
		int pageSize = 5;
		if (!StringUtil.isEmpty(request.getSize())) {
			pageSize = Integer.parseInt(request.getSize());
		}
		int currentPage = 0;
		if (!StringUtil.isEmpty(request.getPage())) {
			currentPage = Integer.parseInt(request.getPage()) - 1;
		}
		Pageable page = PageRequest.of(currentPage, pageSize);
		if (!StringUtil.isEmpty(employeeId)) {
	        activityPage = activityHistoryRepo.findByEmployeeIdOrderByEntryTimestampDesc(employeeId, page);
		}
		
		response.setActivityHistoryPage(activityPage);
		response.setEmployeeId(employeeId);
		
		return response;
	}

	@Override
	public boolean saveAll(List<ActivityHistory> activityHistoryList) {
		if (!GeneralUtil.isListEmpty(activityHistoryList)) {
			activityHistoryRepo.saveAll(activityHistoryList);
			return true;
		}
		return false;
	}

}
