package com.soses.hris.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.repository.EmployeeRepository;

@Component
public class SearchEmployeeBO {

	private EmployeeRepository employeeRepo;

	@Autowired
	public void setEmployeeRepo(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<EmployeeTO> searchEmployeeDetailsById(String employeeId) {
		
		Pageable page = PageRequest.of(0, 2);
		List<Employee> employeeList = employeeRepo.findByEmployeeIdContains(employeeId, page);
		List<EmployeeTO> employeeTOList = null;
		if (!GeneralUtil.isListEmpty(employeeList)) {
			employeeTOList = new ArrayList<>();
			for (Employee employee : employeeList) {
				EmployeeTO employeeTO = EmployeeTransformerUtil.transformEmployeeEntity(employee);
				employeeTOList.add(employeeTO);
			}
		}
		return employeeTOList;
	}
}
