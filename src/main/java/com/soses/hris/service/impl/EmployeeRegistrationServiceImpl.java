package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.AddEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.controller.EmployeeRegistrationController;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeAddressPK;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.entity.EmployeeInfo;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.repository.EmployeeBenefitsRepository;
import com.soses.hris.repository.EmployeeInfoRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeRegistrationService;

/**
 * The Class EmployeeRegistrationServiceImpl.
 *
 * @author hso
 * @since Dec 21, 2021
 */
@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeRegistrationController.class);

	/** The employee repository. */
	private EmployeeRepository employeeRepository;
	
	/** The employee address repository. */
	private EmployeeAddressRepository employeeAddressRepository;
	
	/** The employee info repository. */
	private EmployeeInfoRepository employeeInfoRepository;
	
	/** The employee benefits repository. */
	private EmployeeBenefitsRepository employeeBenefitsRepository;
	
	/**
	 * Sets the employee repository.
	 *
	 * @param employeeRepository the new employee repository
	 */
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	/**
	 * Sets the employee address repository.
	 *
	 * @param employeeAddressRepository the new employee address repository
	 */
	@Autowired
	public void setEmployeeAddressRepository(EmployeeAddressRepository employeeAddressRepository) {
		this.employeeAddressRepository = employeeAddressRepository;
	}

	/**
	 * Sets the employee info repository.
	 *
	 * @param employeeInfoRepository the new employee info repository
	 */
	@Autowired
	public void setEmployeeInfoRepository(EmployeeInfoRepository employeeInfoRepository) {
		this.employeeInfoRepository = employeeInfoRepository;
	}

	/**
	 * Sets the employee benefits repository.
	 *
	 * @param employeeBenefitsRepository the new employee benefits repository
	 */
	@Autowired
	public void setEmployeeBenefitsRepository(EmployeeBenefitsRepository employeeBenefitsRepository) {
		this.employeeBenefitsRepository = employeeBenefitsRepository;
	}

	/**
	 * Register employee.
	 *
	 * @param request the request
	 * @return the base employee response
	 */
	@Override
	public BaseEmployeeResponse registerEmployee(AddEmployeeRequest request) {

		BaseEmployeeResponse response = new BaseEmployeeResponse();
		String employeeId = employeeRepository.getNextEmployeeId().toString();
		log.info("EmployeeId: " + employeeId);
		
		// Employee
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setSuffix(request.getSuffix());
		employee.setMiddleName(request.getMiddleName());
		employee.setNickname(request.getNickname());
		employee.setCellNo(request.getCellNo());
		employee.setTelNo(request.getTelNo());
		employee.setGender(request.getGender());
		employee.setBirthdate(request.getBirthdate());
		employee.setMaritalStatus(request.getMaritalStatus());
		employee.setHiringDate(request.getHiringDate());
		employee.setDivision(request.getDivision());
		employee.setPosition(request.getPosition());
		
		employee = employeeRepository.save(employee);
		
		//permanent address
		List<EmployeeAddress> empAddressList = new ArrayList<>();
		EmployeeAddress address1 = new EmployeeAddress();
		EmployeeAddressPK addressPk1 = new EmployeeAddressPK();
		addressPk1.setEmployeeId(employeeId);
		addressPk1.setAddressType(GlobalConstants.ADDRESS_TYPE_PERMANENT);
		address1.setId(addressPk1);
		address1.setStreet(request.getPermanentStreet());
		address1.setBarangay(request.getPermanentBarangay());
		address1.setCity(request.getPermanentCity());
		address1.setProvince(request.getPermanentProvince());
		empAddressList.add(address1);
		//present address
		EmployeeAddress address2 = new EmployeeAddress();
		EmployeeAddressPK addressPk2 = new EmployeeAddressPK();
		addressPk2.setAddressType(GlobalConstants.ADDRESS_TYPE_PRESENT);
		addressPk2.setEmployeeId(employeeId);
		address2.setId(addressPk2);
		address2.setStreet(request.getPresentStreet());
		address2.setBarangay(request.getPresentBarangay());
		address2.setCity(request.getPresentCity());
		address2.setProvince(request.getPresentProvince());
		empAddressList.add(address2);
		//provincial address
		EmployeeAddress address3 = new EmployeeAddress();
		EmployeeAddressPK addressPk3 = new EmployeeAddressPK();
		addressPk3.setEmployeeId(employeeId);
		addressPk3.setAddressType(GlobalConstants.ADDRESS_TYPE_PROVINCIAL);
		address3.setId(addressPk3);
		address3.setStreet(request.getProvincialStreet());
		address3.setBarangay(request.getProvincialBarangay());
		address3.setCity(request.getProvincialCity());
		address3.setProvince(request.getProvincialProvince());
		empAddressList.add(address3);
		empAddressList = employeeAddressRepository.saveAll(empAddressList);
		
		//employee info
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setEmployeeId(employeeId);
		employeeInfo.setEmergencyName(request.getEmergencyName());
		employeeInfo.setEmergencyAddress(request.getEmergencyAddress());
		employeeInfo.setEmergencyContact(request.getEmergencyContact());
		employeeInfo.setMotherBirthdate(request.getMotherBirthdate());
		employeeInfo.setMotherName(request.getMotherName());
		employeeInfo.setFatherBirthdate(request.getFatherBirthdate());
		employeeInfo.setFatherName(request.getFatherName());
		employeeInfo = employeeInfoRepository.save(employeeInfo);
		
		//employee benefits
		EmployeeBenefits employeeBenefits = new EmployeeBenefits();
		employeeBenefits.setEmployeeId(employeeId);
		employeeBenefits.setSssMembershipDate(request.getSssMembershipDate());
		employeeBenefits.setSssNo(request.getSssNo());
		employeeBenefits.setPhilhealthMembershipDate(request.getPhilHealthMembershipDate());
		employeeBenefits.setPhilhealthNo(request.getPhilHealthNo());
		employeeBenefits.setPagibigMembershipDate(request.getPagibigMembershipDate());
		employeeBenefits.setPagibigNo(request.getPagibigNo());
		employeeBenefits.setTinNo(request.getTinNo());
		employeeBenefits = employeeBenefitsRepository.save(employeeBenefits);
		
		response.setEmployeeId(String.valueOf(employeeId));
		
		return response;
	}

}
