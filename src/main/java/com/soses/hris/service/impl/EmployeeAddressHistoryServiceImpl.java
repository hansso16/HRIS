package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.EmployeeAddressHistoryResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeAddressHistoryTO;
import com.soses.hris.entity.EmployeeAddressHistory;
import com.soses.hris.repository.EmployeeAddressHistoryRepository;
import com.soses.hris.service.EmployeeAddressHistoryService;

@Service("EmployeeAddressHistoryServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeAddressHistoryServiceImpl implements EmployeeAddressHistoryService {

	private EmployeeAddressHistoryRepository employeeAddressHistoryRepo;
	
	@Autowired
	public EmployeeAddressHistoryServiceImpl(EmployeeAddressHistoryRepository employeeAddressHistoryRepo) {
		super();
		this.employeeAddressHistoryRepo = employeeAddressHistoryRepo;
	}


	@Override
	public EmployeeAddressHistoryResponse getEmployeeDetails(String employeeId, String addressType) {

		EmployeeAddressHistoryResponse resp = new EmployeeAddressHistoryResponse();
		if (!StringUtil.isEmpty(addressType) && !StringUtil.isEmpty(employeeId)) {
			List<EmployeeAddressHistory> empAddressHistoryList = employeeAddressHistoryRepo.findByIdEmployeeIdByAddressType(employeeId, addressType);
			List<EmployeeAddressHistoryTO> empAddressTOList = new ArrayList<>();
			if (!GeneralUtil.isListEmpty(empAddressHistoryList)) {
				for (EmployeeAddressHistory empAddressHistory : empAddressHistoryList) {
					EmployeeAddressHistoryTO empAddressHistoryTO = EmployeeTransformerUtil.transformToEmployeeAddressHistoryTO(empAddressHistory);
					empAddressTOList.add(empAddressHistoryTO);
				}
			} 
			
			resp.setEmployeeAddressList(empAddressTOList);
		}
		return resp;
	}

}
