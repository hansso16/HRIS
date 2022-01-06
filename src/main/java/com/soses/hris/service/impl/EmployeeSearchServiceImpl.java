package com.soses.hris.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soses.hris.api.employee.EmployeeSearchRequest;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Employee;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeSearchService;

@Service("EmployeeSearchServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeSearchServiceImpl implements EmployeeSearchService {

	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeSearchServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Page<Employee> searchEmployee(EmployeeSearchRequest request) {

		String employeeId = request.getEmployeeId();
		Page<Employee> employeePage = null;
		if (!StringUtil.isEmpty(employeeId)) {
			int pageSize = 5;
			if (!StringUtil.isEmpty(request.getSize())) {
				pageSize = Integer.parseInt(request.getSize());
			}
	        int currentPage = 0;
	        if (!StringUtil.isEmpty(request.getPage())) {
	        	currentPage = Integer.parseInt(request.getPage()) - 1;
	        }
	        Pageable page = PageRequest.of(currentPage, pageSize);
	        employeePage = employeeRepo.findByEmployeeIdContains(employeeId, page);
		}
		return employeePage;
	}

}
