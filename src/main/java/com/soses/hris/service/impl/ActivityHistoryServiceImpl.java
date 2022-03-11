package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.ActivityHistoryTO;
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
	public List<ActivityHistoryTO> retrieveEmployeeActivity(String employeeId) {
		
		List<ActivityHistoryTO> retList = new ArrayList<>();
		if (!StringUtil.isEmpty(employeeId)) {
			List<ActivityHistory> repoList = activityHistoryRepo.findByEmployeeId(employeeId);
			if (!GeneralUtil.isListEmpty(repoList)) {
				for (ActivityHistory activityHistory : repoList) {
					ActivityHistoryTO activityHistoryTO = null; //transform
					retList.add(activityHistoryTO);
				}
			}
		}
		
		return retList;
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
