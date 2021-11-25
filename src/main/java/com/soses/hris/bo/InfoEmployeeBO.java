package com.soses.hris.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.dto.EmployeeInfoTO;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeInfo;
import com.soses.hris.repository.EmployeeDependentRepository;
import com.soses.hris.repository.EmployeeInfoRepository;

/**
 * The Class InfoEmployeeBO.
 *
 * @author hso
 * @since 22 Nov 2021
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InfoEmployeeBO {

	/** The employee info repo. */
	private EmployeeInfoRepository employeeInfoRepo;
	
	/** The employee dependent repo. */
	private EmployeeDependentRepository employeeDependentRepo;
	
	/**
	 * Instantiates a new info employee BO.
	 *
	 * @param employeeInfoRepo the employee info repo
	 * @param employeeDependentRepo the employee dependent repo
	 */
	@Autowired
	public InfoEmployeeBO(EmployeeInfoRepository employeeInfoRepo, EmployeeDependentRepository employeeDependentRepo) {
		super();
		this.employeeInfoRepo = employeeInfoRepo;
		this.employeeDependentRepo = employeeDependentRepo;
	}

	/**
	 * Retrieve employee info.
	 *
	 * @param employeeId the employee id
	 * @return the employee info TO
	 */
	public EmployeeInfoTO retrieveEmployeeInfo(String employeeId) {
		
		EmployeeInfo employeeInfo = employeeInfoRepo.findByEmployeeId(employeeId);
		EmployeeInfoTO employeeInfoTO = null;
		if (employeeInfo != null) {
			employeeInfoTO = EmployeeTransformerUtil.transformEmployeeInfoEntity(employeeInfo);
		}
		return employeeInfoTO;
	}
	
	/**
	 * Retrieve employee address.
	 *
	 * @param employeeId the employee id
	 * @return the list
	 */
	public List<EmployeeDependentTO> retrieveEmployeeDependent(String employeeId) {

		List<EmployeeDependent> empDependentList = employeeDependentRepo.findByIdEmployeeId(employeeId);
		List<EmployeeDependentTO> empDependentTOList = new ArrayList<>();
		if (!GeneralUtil.isListEmpty(empDependentList)) {
			for (EmployeeDependent empDependent : empDependentList) {
				EmployeeDependentTO empDependentTO = EmployeeTransformerUtil.transformEmployeeDependentEntity(empDependent);
				empDependentTOList.add(empDependentTO);
			}
		}
		return empDependentTOList;
	}
}
